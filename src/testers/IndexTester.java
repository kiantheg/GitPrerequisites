package testers;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import git.Blob;
import git.Index;

class IndexTester {
	
	@Test
	void indexTest() throws IOException {
		Index ind = new Index();
		File index = new File("index");
		assertTrue(index.exists());
	}
	
	@Test
	void objectsTest() throws IOException {
		Index ind = new Index();
		File objectsDir = new File("Objects");
		assertTrue(objectsDir.exists());
	}
	
	@Test
	void addTest() throws IOException {
		Index ind = new Index();
		Blob blobbie = new Blob("naalah.txt");
		File file = new File("naalah.txt");
		ind.addBlob(file.getName());
		String indexLine = Blob.getContent("index");
		assertTrue(indexLine.equals(file.getName() + " : " + blobbie.getSha()));
	}
	
	@Test
	void removeTest() throws IOException {
		Index ind = new Index();
		Blob blobbie = new Blob("naalah.txt");
		File file = new File("naalah.txt");
		ind.addBlob(file.getName());
		ind.removeBlob(file.getName());
		String indexLine = Blob.getContent("index");
		assertTrue(indexLine.equals(""));
	}
}
