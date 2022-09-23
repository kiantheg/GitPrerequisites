package testers;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import git.Tree;

class TreeTester {
	static ArrayList<String> list;
	static String arrContent;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		list = new ArrayList<String>();
		list.add("blob: a94a8fe5ccb19ba61c4c0873d391e987982fbbd3");
		list.add("tree : ab4d8d2a5f480a137067da17100271cd176607a1");
		arrContent="";
		for (String s : list) {
			Scanner scanner = new Scanner(new File ("index"));
			arrContent+=s+"\n";
			while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        if(line.contains(s.subSequence(7, s.length()))) {
		        	s+=line.substring(0,line.indexOf(" "));
		        }
		    }
		}
		Tree tree = new Tree(list);
	}
	@Test
	void testSha1() {
		File check = new File ("Objects/80f604f13ef3bdc02be825df377c5dbd1059f0f1");
		
		assertTrue("Sha-1 code is incorrect", check.exists());
	}

	@Test
	void testTree() throws IOException {
		Path filePath = Path.of("Objects/80f604f13ef3bdc02be825df377c5dbd1059f0f1");
		String fileContent = Files.readString(filePath);
		System.out.println(fileContent);
		System.out.println(arrContent);
		assertTrue("Tree object does not write correctly to file", arrContent.equals(fileContent));
	}

}
