package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class SystemTest {
	
	private FileSystem fileSystem = null;
	private Shell shell = null;

	@Before
	public void setUp(){
		fileSystem = FileSystem.getFileSystem();
		Directory root = new Directory (null, "root");
		fileSystem.setRoot(root);
		
		Directory system = new Directory(fileSystem.root, "system");
		File a = new File(system, "a.txt", 10);
		File b = new File(system, "b.txt", 10);
		File c = new File(system, "c.pdf.", 10);
		
		
		Directory home = new Directory(fileSystem.root, "home");
		File d = new File(home, "d.pdf", 10);
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
	}
	

	@After //Called after each test, at After
	public void tearDown(){		
		fileSystem = null;
		shell = null;
	}
	
	
	@Ignore
    public void printMenuTest() {
		System.out.println("\n\nMENU Test");
		
		shell = new Shell();
		shell.printMenu();
		
	}
	
	
	@Test
    public void pwdTest() {
		System.out.println("\n\nPWD Test");
		Pwd pwd = new Pwd(fileSystem);
		pwd.execute();
		String actual = pwd.toString();
		String expected = "pwd";
		assertThat(actual.equals(expected), is(true));
		
	}
	
	@Test
    public void cdTest() {
		System.out.println("\n\nCD Test");
		
		Cd cd = new Cd(fileSystem, "cd home");
		cd.execute();
		
		Ls ls = new Ls(fileSystem);
		ls.execute();
		
		String actual = cd.toString();
		String expected = "cd home";
		assertThat(actual.equals(expected), is(true));
		
	}
	
	@Test
    public void lsTest() {
		System.out.println("\n\nLS Test");
		
		Cd cd = new Cd(fileSystem, "cd home");
		cd.execute();
		
		Ls ls = new Ls(fileSystem);
		ls.execute();
		
		String actual = ls.toString();
		String expected = "ls";
		assertThat(actual.equals(expected), is(true));
		
	}
	
	@Test
    public void dirInfoTest() {
		System.out.println("\n\nDIRINFO Test");
		
		Cd cd = new Cd(fileSystem, "cd home");
		cd.execute();
		
		Dir dir = new Dir(fileSystem, "dirInfo pictures");
		dir.execute();
		
		String actual = dir.toString();
		
		String expected = "dirInfo pictures";
		
		assertThat(actual.equals(expected), is(true));
		
	}
	
	@Test
    public void dirTest() {
		System.out.println("\n\nDIR Test");
		
		Cd cd = new Cd(fileSystem, "cd home/");
		cd.execute();
		
		Dir dir = new Dir(fileSystem, "dir ");
		dir.execute();
		
		String actual = dir.toString();
		
		String expected = "dir ";
		
		assertThat(actual.equals(expected), is(true));
		
	}
	
	@Test
    public void mkdirTest() {
		System.out.println("\n\nMKDIR Test");
		
		Mkdir mkdir = new Mkdir(fileSystem, "mkdir new");
		mkdir.execute();
		
		
		System.out.println("\nCurrent contents:");
		Ls ls = new Ls(fileSystem);
		ls.execute();
		
		String actual = mkdir.toString();
		
		String expected = "mkdir new";
		
		assertThat(actual.equals(expected), is(true));
		
	}
	
	@Test
    public void rmdirTest() {
		System.out.println("\n\nRMDIR Test");
		
		Rmdir rmdir =  new Rmdir(fileSystem, "rmdir home");
		rmdir.execute();
		
		
		System.out.println("\nCurrent contents:");
		Ls ls = new Ls(fileSystem);
		ls.execute();
		
		String actual = rmdir.toString();
		
		String expected = "rmdir home";
		
		assertThat(actual.equals(expected), is(true));
		
	}
	
	@Test
    public void lnTest() {
		System.out.println("\n\nLN Test");
		
		Ln ln = new Ln(fileSystem, "ln pictures");
		ln.execute();
		
		System.out.println("\nCurrent contents:");
		Ls ls = new Ls(fileSystem);
		ls.execute();
		
		String actual = ln.toString();
		
		String expected = "ln pictures";
		
		assertThat(actual.equals(expected), is(true));
		
	}
	
	@Test
    public void mvTest() {
		System.out.println("\n\nMV Test");
		
		Mv mv = new Mv(fileSystem, "mv home system");
		mv.execute();
		
		Cd cd = new Cd(fileSystem, "cd system/");
		cd.execute();
		
		System.out.println("\nCurrent contents:");
		Ls ls = new Ls(fileSystem);
		ls.execute();
		
		String actual = mv.toString();
		
		String expected = "mv home system";
		
		assertThat(actual.equals(expected), is(true));
		
	}
	
	@Test
    public void cpTest() {
		System.out.println("\n\nCP Test");
		
		Cp cp = new Cp(fileSystem, "cp system home");
		cp.execute();
		
		Cd cd = new Cd(fileSystem, "cd home/");
		cd.execute();
		
		System.out.println("\nCurrent contents:");
		Ls ls = new Ls(fileSystem);
		ls.execute();
		
		String actual = cp.toString();
		
		String expected = "cp system home";
		
		assertThat(actual.equals(expected), is(true));
		
	}
	
	
	@Test
    public void chownTest() {
		System.out.println("\n\nCHOWN Test");
		
		Chown chown = new Chown(fileSystem, "chown home me");
		chown.execute();
		
		String actual = chown.toString();
		String expected = "chown home me";
		assertThat(actual.equals(expected), is(true));
		
	}
	
	@Test
    public void historyTest() {
		System.out.println("\n\nHISTORY Test");
		
		shell = new Shell();
		
		Cd cd = new Cd(fileSystem, "cd home");
		cd.execute();
		shell.getCommandHistory().push(cd);
		
		Ls ls = new Ls(fileSystem);
		//ls.execute();
		shell.getCommandHistory().push(ls);
		
		History history = new History(shell.getCommandHistory());
		history.execute();
		
		String actual = history.toString();
		
		assertThat(!actual.isEmpty(), is(true));
		
	}
	
	@Test
    public void redoTest() {
		System.out.println("\n\nREDO Test");
		
		shell = new Shell();
		
		Cd cd = new Cd(fileSystem, "cd home");
		cd.execute();
		shell.getCommandHistory().push(cd);
		
		Ls ls = new Ls(fileSystem);
		//ls.execute();
		shell.getCommandHistory().push(ls);
		
		Redo redo = new Redo(shell.getCommandHistory());
		redo.execute();
		
		String actual = redo.toString();
		
		assertThat(!actual.isEmpty(), is(true));
		
	}
	

	@Test
    public void sortTest() {
		System.out.println("\n\nSORT Test");
		
		Sort sort = new Sort(fileSystem, "sort reverse home");
		sort.execute();
	
		String actual = sort.toString();
		
		assertThat(!actual.isEmpty(), is(true));
		
	}
	
	
	@Test
    public void countTest() {
		System.out.println("\n\nCOUNT Test");
		
		Count count = new Count(fileSystem, "count home");
		count.execute();
	
		String actual = count.toString();
		
		assertThat(!actual.isEmpty(), is(true));
		
	}
	
	@Test
    public void duTest() {
		System.out.println("\n\nDU Test");
		
		Du du = new Du(fileSystem, "du home");
		du.execute();
	
		String actual = du.toString();
		
		assertThat(!actual.isEmpty(), is(true));
		
	}
	
	@Test
    public void searchTest() {
		System.out.println("\n\nSEARCH Test");
		
		Search search = new Search(fileSystem, "search .txt");
		search.execute();
	
		String actual = search.toString();
		
		assertThat(!actual.isEmpty(), is(true));
		
	}
	

}
