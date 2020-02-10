package com.twu.biblioteca.classes;

import com.twu.biblioteca.interfaces.IPrompter;

import javax.naming.InvalidNameException;
import java.util.ArrayList;

public class ReturnItem extends LibraryItemAction {

    private IPrompter _I_prompter;
    private String _itemName;

    public ReturnItem(IPrompter IPrompter, ArrayList itemList, String itemName) {
        super(itemList);
        _I_prompter = IPrompter;
        _itemName = itemName;
    }

    public void returnItem () {
        _I_prompter.print("Enter name of " + _itemName + " to return: ");
        String itemToCheckOut = _I_prompter.readInput();
        try {
            LibraryItem item = super.validateItemRequest(itemToCheckOut, false);
            super.amendItemAvailabilityAfterReturn(item);
            _I_prompter.printWithNewLine("Thank you for returning the " + _itemName);

        } catch (InvalidNameException exception) {
            _I_prompter.printWithNewLine("*** That is not a valid "+ _itemName + " to return ***");
        }
    }
}