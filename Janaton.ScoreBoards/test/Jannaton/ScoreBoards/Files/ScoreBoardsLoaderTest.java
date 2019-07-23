/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Files;


import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author german
 */
public class ScoreBoardsLoaderTest {
    
    public ScoreBoardsLoaderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class ScoreBoardsLoader.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ScoreBoardsLoader result = ScoreBoardsLoader.getInstance();
        assertNotNull(result);
    }
}
