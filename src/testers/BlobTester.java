package testers;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.*;

import org.junit.jupiter.api.Test;

import git.Blob;

class BlobTester {
	
	@Test
	void nameTest() throws IOException {
		Blob blobbie = new Blob ("naalah.txt");
		System.out.println(blobbie.getSha());
		assertEquals("1510fb057be4a79b98d9491b1020231484331d9f", blobbie.getSha());
	}
	@Test
	void contentTest() throws IOException {
		File file = new File("naalah.txt");
		Blob blobbie = new Blob("naalah.txt");
		assertEquals(Blob.getContent(file.getName()), Blob.getContent("Objects/"+ blobbie.getSha()));
	}
}