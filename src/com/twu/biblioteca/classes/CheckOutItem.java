package com.twu.biblioteca.classes;
import com.twu.biblioteca.interfaces.IPrompter;
import javax.naming.InvalidNameException;
import java.util.ArrayList;

public class CheckOutItem extends LibraryItemAction {
    private IPrompter _I_prompter;
    private String _itemName;
    private User _user;

    public CheckOutItem(IPrompter prompter, ArrayList itemList, String itemType, User user) {
        super(itemList);
        _I_prompter = prompter;
        _itemName = itemType;
        _user = user;
    }

    public void checkOut() {
        _I_prompter.print("Enter name of " + _itemName + " to borrow: ");
        String itemToCheckOut = _I_prompter.readInput();
        try {
            LibraryItem item = super.validateItemRequest(itemToCheckOut, true);
            super.amendItemAvailabilityAfterCheckout(item);
            item.setCheckedOutBy(_user.getLibraryNumber());
            _I_prompter.printWithNewLine("Thank you! Enjoy the " + _itemName);
        } catch (InvalidNameException exception) {
            _I_prompter.printWithNewLine("*** Sorry, that " + _itemName + " is not available ***");
        }
    }
}
