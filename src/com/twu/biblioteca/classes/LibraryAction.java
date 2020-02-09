package com.twu.biblioteca.classes;

import javax.naming.InvalidNameException;
import java.util.ArrayList;

public class LibraryAction {

    private ArrayList<LibraryItem> _itemList;

    public LibraryAction(ArrayList itemList) {
    _itemList = itemList;
    }


    public LibraryItem validateItemRequest(String itemName, Boolean availableStatus) throws InvalidNameException {
        for (LibraryItem item: _itemList) {
            if (item.getName().equalsIgnoreCase(itemName) && item.getAvailable().equals(availableStatus)) {
                return item;
            }
        }
        throw new InvalidNameException();
    }
}
