package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class FileSystemTest {
	
	@Test
	public void initilizeFileSystemTest() {
		assertTrue(!FileSystem.getFileSystem().equals(null));
	}
	
	

	@Test
	public void showAllElementsAndTestContents() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		
		fileSystem.getRootDirectory();
		
		Directory system = new Directory(fileSystem.root, "system");
		File a = new File(system, "a", 10);
		File b = new File(system, "b", 10);
		File c = new File(system, "c", 10);
		
		
		Directory home = new Directory(fileSystem.root, "home");
		File d = new File(home, "d", 10);
		
		Directory pictures = new Directory(home, "pictures");
		File e = new File(pictures, "e", 10);
		File f = new File(pictures, "f", 10);
		
		fileSystem.root.appendChild(system);
		fileSystem.root.appendChild(home);
		
		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		
		pictures.appendChild(e);
		pictures.appendChild(f);
		
		home.appendChild(d);
		home.appendChild(pictures);
		
		fileSystem.showAllElements();
		
		
		
		assertThat(system.getChildren().contains(a), is(true)); 
		assertThat(pictures.getChildren().contains(f), is(true)); 
		assertThat(pictures.getChildren().contains(b), is(false));
		assertThat(home.getChildren().contains(home), is(false));
		
	}
	
	@Test
	public void showAllElementsSizeTest() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		
		fileSystem.getRootDirectory();
		
		Directory system = new Directory(fileSystem.root, "system");
		File a = new File(system, "a", 10);
		File b = new File(system, "b", 10);
		File c = new File(system, "c", 10);
		
		
		Directory home = new Directory(fileSystem.root, "home");
		File d = new File(home, "d", 10);
		
		Directory pictures = new Directory(home, "pictures");
		File e = new File(pictures, "e", 10);
		File f = new File(pictures, "f", 10);
		
		fileSystem.root.appendChild(system);
		fileSystem.root.appendChild(home);
		
		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		
		pictures.appendChild(e);
		pictures.appendChild(f);
		
		home.appendChild(d);
		home.appendChild(pictures);
		
		int actual = fileSystem.root.getSize();
		int expected = 60;
		
		assertThat(actual, is(expected)); 
		
		
	}

}
