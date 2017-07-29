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
		Link x = new Link(home, "x");
		x.setElement(system);
		
		Directory pictures = new Directory(home, "pictures");
		File e = new File(pictures, "e", 10);
		File f = new File(pictures, "f", 10);
		Link y = new Link(pictures, "y", e);
		Link x2 = new Link(pictures, "x2", x);
		
		fileSystem.root.appendChild(system);
		fileSystem.root.appendChild(home);
		
		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		
		pictures.appendChild(e);
		pictures.appendChild(f);
		pictures.appendChild(y);
		pictures.appendChild(x2);
		
		home.appendChild(d);
		home.appendChild(pictures);
		home.appendChild(x);
		
		fileSystem.showAllElements();
		
		assertThat(system.getChildren().contains(a), is(true)); 
		assertThat(pictures.getChildren().contains(f), is(true)); 
		assertThat(pictures.getChildren().contains(b), is(false));
		assertThat(home.getChildren().contains(home), is(false));
		assertThat(home.getChildren().contains(x), is(true));
		
	}
	
	@Test
	public void showAllElementsSizeTest() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		
		fileSystem.getRootDirectory();

		Directory system = new Directory(fileSystem.root, "system");
		File a = new File(system, "a", 10);
		File b = new File(system, "b", 10);
		File c = new File(system, "c", 10);
		Link p = new Link(system, "p", c);
		Link p1 = new Link(system, "p1", p);
		
		
		Directory home = new Directory(fileSystem.root, "home");
		File d = new File(home, "d", 10);
		Link x = new Link(home, "x");
		x.setElement(system);
		
		Directory pictures = new Directory(home, "pictures");
		File e = new File(pictures, "e", 10);
		File f = new File(pictures, "f", 10);
		Link y = new Link(pictures, "y", e);
		Link x2 = new Link(pictures, "x2", x);
		Link x3 = new Link(pictures, "x3", x2);
		
		fileSystem.root.appendChild(system);
		fileSystem.root.appendChild(home);
		
		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		system.appendChild(p);
		system.appendChild(p1);
		
		pictures.appendChild(e);
		pictures.appendChild(f);
		pictures.appendChild(y);
		pictures.appendChild(x2);
		pictures.appendChild(x3);
		
		home.appendChild(d);
		home.appendChild(pictures);
		home.appendChild(x);
		
		assertThat(x.getTargetSize(), is(system.getSize())); 
		assertThat(x2.getTargetSize(), is(system.getSize())); 
		assertThat(y.getTargetSize(), is(e.getSize()));
		assertThat(x3.getTargetSize(), is(system.getSize())); 
		assertThat(fileSystem.getRootDirectory().getSize(), is(60)); 
		
		
	}

}
