package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;

public class FileSystemVisitorTest {
	
	@Test
	public void CountingVisitorTest() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		
		fileSystem.getRootDirectory();
		
		Directory system = new Directory(fileSystem.root, "system");
		File a = new File(system, "a", 10);
		File b = new File(system, "b", 10);
		File c = new File(system, "c", 10);
		
		
		Directory home = new Directory(fileSystem.root, "home");
		File d = new File(home, "d.txt", 10);
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
		
		CountingVisitor visitor = new CountingVisitor();
		fileSystem.root.accept(visitor);
		
		assertThat(visitor.getDirNum(), is(4));
		assertThat(visitor.getFileNum(), is(6));
		assertThat(visitor.getLinkNum(), is(3));
	}
	
	@Test
	public void SizeCountingVisitorTest() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		
		fileSystem.getRootDirectory();
		
		Directory system = new Directory(fileSystem.root, "system");
		File a = new File(system, "a", 10);
		File b = new File(system, "b", 10);
		File c = new File(system, "c", 10);
		
		
		Directory home = new Directory(fileSystem.root, "home");
		File d = new File(home, "d.txt", 10);
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
		
		SizeCountingVisitor visitor1 = new SizeCountingVisitor();
		fileSystem.root.accept(visitor1);
		
		SizeCountingVisitor visitor2 = new SizeCountingVisitor();
		system.accept(visitor2);
		
		SizeCountingVisitor visitor3 = new SizeCountingVisitor();
		home.accept(visitor3);
		
		assertThat(visitor1.getTotalSize(), is(fileSystem.root.getSize()));
		assertThat(visitor2.getTotalSize(), is(system.getSize()));
		assertThat(visitor3.getTotalSize(), is(home.getSize()));
	}
	
	@Test
	public void FileSearchVisitorTest() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		
		fileSystem.getRootDirectory();
		
		Directory system = new Directory(fileSystem.root, "system");
		File a = new File(system, "a.jpg", 10);
		File b = new File(system, "b.txt", 10);
		File c = new File(system, "c", 10);
		
		
		Directory home = new Directory(fileSystem.root, "home");
		File d = new File(home, "d.txt", 10);
		Link x = new Link(home, "x");
		x.setElement(system);
		
		Directory pictures = new Directory(home, "pictures");
		File e = new File(pictures, "e.jpg", 10);
		File f = new File(pictures, "f.jpg", 10);
		Link y = new Link(pictures, "y.jpg", e);
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
		
		FileSearchVisitor visitor = new FileSearchVisitor(".txt");
		fileSystem.root.accept(visitor);
		int actual = visitor.getFoundFiles().size();
		
		FileSearchVisitor visitor2 = new FileSearchVisitor(".jpg");
		fileSystem.root.accept(visitor2);
		int actual2 = visitor.getFoundFiles().size();
	
		assertThat(actual, is(2));
		assertThat(actual2, is(2));
		
	}
	

}
