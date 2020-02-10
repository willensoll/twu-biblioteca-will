package com.twu.biblioteca.classes;

import com.twu.biblioteca.interfaces.IPrompter;

import javax.naming.InvalidNameException;
import java.util.ArrayList;

public class CheckOutItem extends LibraryAction {

    private IPrompter _I_prompter;
    private String _itemName;


    public CheckOutItem(IPrompter prompter, ArrayList itemList, String itemType) {
        super(itemList);
        _I_prompter = prompter;
        _itemName = itemType;
    }

    public void checkOut() {
        _I_prompter.print("Enter name of "+ _itemName +" to borrow: ");
        String itemToCheckOut = _I_prompter.readInput();
        try {
            LibraryItem item = super.validateItemRequest(itemToCheckOut, true);
            super.amendItemAvailabilityAfterCheckout(item);
            _I_prompter.printWithNewLine("Thank you! Enjoy the " + _itemName);
        } catch (InvalidNameException exception) {
            _I_prompter.printWithNewLine("*** Sorry, that " + _itemName + " is not available ***");
        }
    }


}
