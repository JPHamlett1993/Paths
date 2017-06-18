package utility;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by jphamlett on 6/16/17.
 */
public class Test_fileIO {

    @Test
    public void testReadFile() throws IOException {
        String expectedFileContent = "##########\n#A...#...#\n#.#.##.#.#\n#.#.##.#.#\n#.#....#B#\n#.#.##.#.#\n#....#...#\n##########";
        String readFile = fileIO.readFile("test/maze1.txt", Charset.defaultCharset()).trim(); //Trailing whitespace
        assertEquals(readFile, expectedFileContent);
    }
}
