package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class CheckoutBookTests {

    private Prompter prompterMock;
    private CheckoutBook checkoutBook;

    @Before
    public void setUpCheckoutBookTests() {
        prompterMock = mock(Prompter.class);
        checkoutBook = new CheckoutBook(prompterMock);
    }

    @Test
    public void validate_book_req_returns_true_if_book_found_in_list(){
        Boolean test = checkoutBook.validateBookRequest("Catcher in the Rye");
        assertTrue(test);
    }

    @Test
    public void validate_book_req_returns_true_if_book_found_in_list_ignores_case(){
        Boolean test = checkoutBook.validateBookRequest("CATCHer in the rYe");
        assertTrue(test);
    }

    @Test
    public void validate_book_req_returns_false_if_book_found_in_list(){
        Boolean test = checkoutBook.validateBookRequest("The world according to Will");
        assertFalse(test);
    }
}
