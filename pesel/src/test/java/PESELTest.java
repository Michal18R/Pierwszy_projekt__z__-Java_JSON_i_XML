import org.junit.Test;

import javax.swing.*;

import java.util.Scanner;

import static org.junit.Assert.*;


public class PESELTest {

    @Test
    public void test_correctPesel() throws Exception {
        assertTrue(PESEL.isPeselCorrect("96022338858"));
    }

    @Test
    public void test_incorrectPesel() throws Exception {
        assertFalse(PESEL.isPeselCorrect("99999999999"));

    }

    @Test
    public void test_incorrectlengthPesel() throws Exception {
        assertFalse(PESEL.isPeselCorrect("960223388589999"));
        assertFalse(PESEL.isPeselCorrect("960"));
    }

}
