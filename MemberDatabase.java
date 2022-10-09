import myPackage.Date;
/**
 * MemberDatabase class
 * creates a list of all the members of the gym
 * @author Brandon Yuen
 */
public class MemberDatabase {
    /** An array of member type to store member details.*/
     private Member [] mlist;
     private int size;
    private int array_size;

    /**
     * MemberDatabase constructor
     */
    public MemberDatabase()
     {
         this.mlist = new Member[4];
         this.size = 0;
     }

    /**
     * Getter method for the database array size
     * @return the int size of the database array
     */
     public int getSize(){
        return this.size;
     }

    /**
     * Getter method for the whole database array
     * @return the array of all the members at the gyms
     */
     public Member[] getMemberArray()
     {
         return mlist;
     }

    /**
     * Helper method that finds the input member inside the current member database
     * @param member
     * @return the index of the inputted member inside the array
     */
     private int find(Member member)
     {
         String fname = member.getfname().toLowerCase();
         String lname = member.getlname().toLowerCase();
         Date dob = member.getdob();
         for(int i = 0; i < mlist.length; i++)
         {
             if (mlist[i] == null){
                 continue;
             }

             if(mlist[i].getfname().toLowerCase().equals(fname) && mlist[i].getlname().toLowerCase().equals(lname) && mlist[i].getdob().compareTo(dob) == 0)
             {
                 return i;
             }
         }
         return -1;
     }

    /**
     * helper method that increases the size of the member database array when needed
     */
    private void grow()
     {
         Member[] newmlist = new Member[mlist.length + 4];

         for (int i = 0 ; i < mlist.length ; i++)
         {
             newmlist[i] = mlist[i];
         }

         mlist = newmlist;
     }

    /**
     * Helper method that adds the inputted member into the database array
     * @param member
     * @return boolean value if the inputted member has successfully been added to the list
     */
     public boolean add(Member member)
     {
        if (find(member) >= 0){
            return false;
        }
        if (size == mlist.length)
        {
            grow();
        }

        if(member.equals(null))
            return false;

        mlist[size] = member;
        size++;

        return true;
     }

    /**
     * Helper method that removes the inputted member from the member database array
     * @param member
     * @return boolean value that shows if the inputted member has been successfully removed from the list
     */
     public boolean remove(Member member)
     {
         int index = find(member);
         if (index == -1)
         {
             return false;
         }

         Member[] temp_member_array = new Member[mlist.length];

         for(int i=0, j=0; i < mlist.length; i++)
         {
             if(i!= index){
                 temp_member_array[j++] = mlist[i];
             }
         }

         size--;
         mlist = temp_member_array;
         shiftDelete();
         return true;

     }

    /**
     * Helper method that prints the whole database in no specific order
     */
    public void print ()
     {
         if (size  == 0) {
             System.out.println("Member database is empty!");
             return;
         }
         System.out.println("\n\n-list of members-");

         print_array(mlist);

         System.out.println("-end of list-\n\n");
     } //print the array contents as is

    /**
     * Helper method that prints the inputted helper array
     * @param arr
     */
    private void print_array(Member[] arr)
    {
        for(int i = 0; i < arr.length && arr[i] != null; i++)
        {
            System.out.println(arr[i].toString());
        }
    }

    /**
     * Selection sort helper method that is called to sort an inputted array
     * @param temp_array1
     */
    private void selection_sort_for_ByExpirationDate(Member[] temp_array1)
    {
        int array_size = temp_array1.length;

        for (int i = 0; i < array_size - 1; i++)
        {
            int min_index = i;

            for (int j = i + 1; j < array_size; j++)
            {
                if (temp_array1[j] != null && temp_array1[min_index] != null)
                {
                    Date dateone = temp_array1[j].getexpire();
                    Date datetwo = temp_array1[min_index].getexpire();

                    if ((dateone).compareTo(datetwo) == -1)
                    {
                        min_index = j;
                    }
                }
            }

            Member temp = temp_array1[min_index];
            temp_array1[min_index] = temp_array1[i];
            temp_array1[i] = temp;
        }

        print_array(temp_array1);
    }

    /**
     * Helper method that sorts and prints the database based on the members expiration dates
     */
    public void printByExpirationDate()
    {
        if (size == 0) {
            System.out.println("Member database is empty!");
            return;
        }
        System.out.println("-list of members sorted by membership expiration date-");

        Member[] temp_array1 = new Member[mlist.length];

        for (int i = 0 ; i < mlist.length ; i++)
        {
            temp_array1[i] = mlist[i];
        }

        selection_sort_for_ByExpirationDate(temp_array1);

        System.out.println("-end of list-\n\n");
    } //sort by county and then zipcode

    /**
     * Helper method that sorts and prints the database based on the members counties
     */
    public void printByCounty()
    {
      if(size==0)
      {
          System.out.println("Member database is empty!");
          return;
      }
      System.out.println("-list of members sorted by county and zipcode-");
      Member[] temp_array2 = new Member[mlist.length];
        for (int i = 0 ; i < mlist.length ; i++)
        {
            temp_array2[i] = mlist[i];
        }
        for(int i = 0; i < array_size - 1; i++)
        {
            for (int j = i + 1; j < array_size; j++)
            {
                if (temp_array2[i] != null && temp_array2[j] != null)
                {
                    String county1 = temp_array2[i].getLocation().getCounty();
                    String county2 = temp_array2[j].getLocation().getCounty();

                    if(county1.compareTo(county2) > 0)
                    {
                        Member temp = temp_array2[i];
                        temp_array2[i] = temp_array2[j];
                        temp_array2[j] = temp;
                    }
                }
            }
        }

        print_array(temp_array2);

        System.out.println("-end of list-\n\n");
    }

    /**
     * Helper method that sorts and prints the database based on the members last name and first nane's
     */
     public void printByName()
     {
         if(size==0)
         {
             System.out.println("Member database is empty!");
             return;
         }
         System.out.println("-list of members sorted by last name and first name-");
         Member[] temp_array2 = new Member[mlist.length];
         for (int i = 0 ; i < mlist.length ; i++)
         {
             temp_array2[i] = mlist[i];
         }
         for (int i = 0; i < array_size - 1; i++)
         {
             for (int j = i + 1; j < array_size; j++)
             {
                 if (temp_array2[i] != null && temp_array2[j] != null)
                 {
                     String lname1 = temp_array2[i].getlname();
                     String lname2 = temp_array2[j].getlname();

                     if (lname1.compareTo(lname2) == 1){
                         Member temp = temp_array2[i];
                         temp_array2[i] = temp_array2[j];
                         temp_array2[j] = temp;
                     }
                     else if(lname1.compareTo(lname2) == -1){
                         Member temp = temp_array2[j];
                         temp_array2[i] = temp_array2[i];
                         temp_array2[j] = temp;
                     }
                 }
             }
         }

         print_array(temp_array2);

         System.out.println("-end of list-\n\n");
     }

    /**
     * Helper method that moves all the members up one index when a member is removed from the database.
     */
    private void shiftDelete (){
        Member[] newList = new Member[size];
        int pointer = 0;
        for (int i = 0; i < mlist.length; i++){
            if (!(mlist[i] == null)){
                newList[pointer] = mlist[i];
                pointer++;
            }
        }
        for(int a = 0; a < newList.length; a++){
            System.out.println(newList[a]);
        }
        mlist = newList;
     }
}