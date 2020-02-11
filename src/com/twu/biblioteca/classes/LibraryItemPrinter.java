package com.twu.biblioteca.classes;

import com.twu.biblioteca.interfaces.IPrompter;

import java.util.ArrayList;

public class LibraryItemPrinter {

    private IPrompter _I_prompter;
    private ArrayList<LibraryItem> _itemList;

    public LibraryItemPrinter(IPrompter IPrompter, ArrayList itemList) {

        _I_prompter = IPrompter;
        _itemList = itemList;
    }

    public void printAvailableList() {
        for (LibraryItem item: _itemList) {
            if (item.getAvailable()) {
                _I_prompter.printWithNewLine(item.toListing());
            }
        }
    }

    public void printCheckedOutList() {
        for (LibraryItem item: _itemList) {
            if (!item.getAvailable()) {
                _I_prompter.printWithNewLine(item.toListingLibView());
            }
        }
    }
}
