import com.thoughtworks.ticktactoe.TickTacToeApp;
import com.thoughtworks.ticktactoe.TickTacToeGame;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by jmann on 6/18/15.
 */
public class TickTacToeAppTest {
    @Test
    public void shouldCreateBoardWhenAppStarts(){
        TickTacToeGame tickTacToeGame = mock(TickTacToeGame.class);
        TickTacToeApp tickTacToeApp = new TickTacToeApp(tickTacToeGame);
        tickTacToeApp.start();
        verify(tickTacToeGame).createBoard();
    }

}
