// hello
import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class MarkdownParseTest {
    /*@Test
    public void testDefaultLinkMethod() throws IOException {
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }*/
    @Test
    public void testSnippet1Group() throws IOException {
        Path fileName = Path.of("Snippet1.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), 
            GroupMarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet1Review() throws IOException {
        Path fileName = Path.of("Snippet1.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), 
            ReviewedMarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet2Group() throws IOException {
        Path fileName = Path.of("Snippet2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("a.com", "a.com(())", "example.com"), 
            GroupMarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet2Review() throws IOException {
        Path fileName = Path.of("Snippet2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("a.com", "a.com(())", "example.com"), 
            ReviewedMarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet3Group() throws IOException {
        Path fileName = Path.of("Snippet3.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"), 
            GroupMarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet3Review() throws IOException {
        Path fileName = Path.of("Snippet3.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"), 
            ReviewedMarkdownParse.getLinks(contents));
    }
   
}