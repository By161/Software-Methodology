package com.example.project_4;

/**
 * Customizable interface is used as a framework for adding a removing attributes from specified
 * objects for other classes that implement it
 * @Author Brandon Yuen, Anna Kryzanekas
 * @param <E>
 */
public interface Customizable<E> {

    /**
     * Adds attributes to a specified object
     * @param obj the specified attribute that is to be added to the object
     * @return true if attribute is successfully added and false if not
     */
    boolean add(Object obj);

    /**
     * Removes attributes to a specified object
     * @param obj the specified attribute that is to be removed from the object
     * @return true if attribute is successfully removed and false if not
     */
    boolean remove(Object obj);
}
