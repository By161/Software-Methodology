package com.example.project_4;

/**
 * Interface that allows objects to be customized by adding/removing attributes to them respectively
 * @Author Brandon Yuen, Anna Kryzanekas
 * @param <E> element parameter
 */
public interface Customizable<E> {
    /**
     * Adds an attribute to an object
     * @param obj the attribute to be added to an object
     * @return true if added, false otherwise
     */
    boolean add(Object obj);

    /**
     * Removes an attribute from an object
     * @param obj the attribute to be removed from an object
     * @return true if removed, false otherwise
     */
    boolean remove(Object obj);
}
