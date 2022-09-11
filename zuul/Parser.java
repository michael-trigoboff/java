import java.util.Scanner;

public class Parser 
{
    private Scanner reader = new Scanner(System.in);         // source of command input

    public UserCommand getCommand() 
    {
        String			inputLine;   	// will hold the full input line
        String			word1 = null;
        String			word2 = null;
        GameCommand		cmd;

        System.out.print("> ");     	// print prompt

        inputLine = reader.nextLine();

        // find up to two words on the line
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();			// get first word
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();		// get second word
                // note: we just ignore the rest of the input line.
            }
        }

        // Check whether this word is known. If so, create a command.
        // If not, create a "null" command (for unknown command).
        cmd = GameCommand.parse(word1);
        if(cmd != null)
            return new UserCommand(cmd, word2);
        else
            return null; 
    }
}