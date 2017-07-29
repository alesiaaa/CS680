package edu.umb.cs.cs680;

import java.util.Scanner;

public class Shell {
	private CommandHistory commandHistory;
	String enterCommand = "fileSystem > ";
	Scanner scanner = null;
	
	public Shell() {
		commandHistory = new CommandHistory();
		
		
	}
	
	public void getStarted (Shell shell, FileSystem fileSystem){
		System.out.print(enterCommand);
		scanner = new Scanner(System.in);
	
		try {
		enterCommand(scanner, shell, fileSystem);
		
		} finally {
			scanner.close();
		}
	}
	
	
	public CommandHistory getCommandHistory (){
		return this.commandHistory;
	}
	
	public void printMenu() {
		
		StringBuilder showMenu = new StringBuilder();
		
		String header = "\n\t\t -- Shell Prompt: Commands -- \n";
		
		String pwd = "pwd\t\t-> Print the current working directory\n";
		String cdDir = "cd <dir name> \t-> Change the current directory to the specified directory\n"; 
		String cdBack = "\t\t{..}(move to the parent directory of the current directory.)\n";
		String cdRoot = "\t\t-> Change the current directory to the root directory\n";
		String ls = "ls\t\t->Print the name of every file, directory and link in the current directory\n";
		String dir = "dir\t\t->Print the information (i.e., kind, name, size and owner) of every file, \ndirectory and link in the current directory\n";
		String dirInfo = "dir <dir/file name>\t->Print the specified directory’s/file’s information\n";
		String mkdir = "mkdir <dir name>\t->Make the specified directory in the current directory\n";
		String rmdir = "rmdir <dir name>\t->Remove the specified directory in the current directory\n";
		String ln = "ln <target (real) dir/file> <link (alias) dir/file>\t->Make a link\n";
		String mv ="mv <dir/file> <destination dir>\t->Move a directory/file to the destination directory\n";
		String cp = "cp <dir/file> <destination dir>\t->Copy a directory/file to the destination directory\n";
		String chown = "chown<dir/file> <owner>\t\t->Change the owner of a file/directory. Just name for current dir.\n";
		String history = "history\t\t->Print a sequence of previously-executed commands\n";
		String redo = "redo\t\t->Redo the most recently-executed command\n";
		String sort = "sort <reverse/time> <dir name/blank for current>\t\t->Sort directories and files in the current directory. Blank for alphabetical\n";
		
		// Command for 3 visitor classes
		String count = "count\t\t->Retreive number of elements in directory\n";
		String du = "du\t\t->Get directory disk usage\n";
		String search = "search\t\t->Search for a string\n";
		
		// Show menu again
		String menu = "menu\t\t->To view all menu options\n";
		
		// Quit
		String quit = "quit\t\t->Exit the program\n";
		String selectCommand = "\nPlease enter your desired command.\n";
		
		showMenu.append(header + "\n");
		showMenu.append(pwd + cdDir + cdBack + cdRoot + ls + dir + dirInfo + mkdir);
		showMenu.append(rmdir + ln + mv + cp + chown + history + redo + sort);
		showMenu.append(count + du + search + menu + quit);
		showMenu.append(selectCommand);
		
		System.out.print(showMenu);
		
	}
	
	private void enterCommand(Scanner scanner, Shell shell, FileSystem fs){
		
		String input = scanner.nextLine();
		
		if (input.matches("pwd") || input.matches("pwd ")){
			
			Pwd pwd = new Pwd(fs);
			pwd.execute();
			shell.commandHistory.push(pwd);
		
		} else if (input.matches("cd "+".") || input.matches("cd") 
				|| input.matches("cd ") || input.matches("cd"+".")
				|| input.matches("cd"+"..") || input.matches("cd "+"..")
				|| input.matches("cd "+".*[a-zA-Z1-9]+.*")) {
			
			Cd cd = new Cd(fs, input);
			cd.execute();
			shell.commandHistory.push(cd);
					
		} else if (input.matches("ls") || input.matches("ls ")) {
			
			Ls ls = new Ls(fs);
			ls.execute();
			shell.commandHistory.push(ls);
			
		} else if (input.matches("dir "+".*[a-zA-Z1-9]+.*") || input.matches("dir ")
				|| input.matches("dir")) {
			
			Dir dir = new Dir(fs, input);
			dir.execute();
			shell.commandHistory.push(dir);
			
		} else if (input.matches("mkdir "+".*[a-zA-Z1-9]+.*") || input.matches("mkdir")
				|| input.matches("mkdir ")) {
			
			Mkdir mkdir = new Mkdir(fs, input);
			mkdir.execute();
			shell.commandHistory.push(mkdir);
			
		} else if (input.matches("rmdir "+".*[a-zA-Z1-9]+.*") || input.matches("rmdir")
				|| input.matches("rmdir ")) {
			
			Rmdir rmdir = new Rmdir(fs, input);
			rmdir.execute();
			shell.commandHistory.push(rmdir);
			
		} else if (input.matches("ln "+".*[a-zA-Z1-9]+.*") || input.matches("ln")
				|| input.matches("ln ")) {
			
			Ln ln = new Ln(fs, input);
			ln.execute();
			shell.commandHistory.push(ln);
			
		} else if (input.matches("mv "+".*[a-zA-Z1-9]+.*") || input.matches("mv")
				|| input.matches("mv ")) {
			
			Mv mv = new Mv(fs, input);
			mv.execute();
			shell.commandHistory.push(mv);
			
		} else if (input.matches("cp "+".*[a-zA-Z1-9]+.*") || input.matches("cp")
				|| input.matches("cp ")) {
			
			Cp cp = new Cp(fs, input);
			cp.execute();
			shell.commandHistory.push(cp);
			
		} else if (input.matches("chown "+".*[a-zA-Z1-9]+.*") || input.matches("chown")
				|| input.matches("chown ")){
			
			Chown chown = new Chown(fs, input);
			chown.execute();
			shell.commandHistory.push(chown);
			
		} else if (input.matches("history") || input.matches("history ")) {
			
			History history = new History(shell.getCommandHistory());
			history.execute();
			shell.commandHistory.push(history);
			
		} else if (input.contains("redo")|| input.matches("redo ") ) {
			
			Redo redo = new Redo(shell.getCommandHistory());
			redo.execute();
			
			//will not add to history due to overflow exception
			
		} else if (input.matches("sort" +".*[a-zA-Z1-9]+.*") || input.matches("sort")
				|| input.matches("sort ")) {
			
			Sort sort = new Sort(fs, input);
			sort.execute();
			shell.commandHistory.push(sort);
			
			
		} else if (input.matches("count" +".*[a-zA-Z1-9]+.*") || input.matches("count")
				|| input.matches("count ")) {
			
			Count count = new Count(fs, input);
			count.execute();
			shell.commandHistory.push(count);
			
			
		} else if (input.matches("du" +".*[a-zA-Z1-9]+.*") || input.matches("du")
				|| input.matches("du ")) {
			
			Du du = new Du (fs, input);
			du.execute();
			shell.commandHistory.push(du);
			
			
		} else if (input.matches("search" +".*[a-zA-Z1-9]+.*") || input.matches("search")
				|| input.matches("search ")) {
			
			Search search = new Search (fs, input);
			search.execute();
			shell.commandHistory.push(search);
			
		} else if (input.matches("menu") || input.matches("menu ") ) {
			
			printMenu();
			
		} else if (input.contains("quit")) {
			
			System.out.println("Goodbye!\n");
			System.exit(0);
			
		} else {
			System.out.print("Your command was not recognized. Please try again.\n");
			System.out.print(this.enterCommand);
			enterCommand(scanner, shell, fs);
		}
		
		
		System.out.print(this.enterCommand);
		enterCommand(scanner, shell, fs);
			
	}
	
	
	public static void main(String args[]) {
		FileSystem fileSystem = FileSystem.getFileSystem();
		Directory root = new Directory (null, "root");
		fileSystem.setRoot(root);
		
		Directory system = new Directory(fileSystem.root, "system");
		File a = new File(system, "a.txt", 10);
		File b = new File(system, "b.txt", 10);
		File c = new File(system, "c.pdf", 10);
		
		
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
		
		Shell shell = new Shell();
		
		shell.getStarted(shell, fileSystem);
		
	}
	
	

}
