package com.meti.command;

import java.util.Scanner;

class CompileRuntime {
	public static void main(String[] args) {
		var console = CompileConsole.INSTANCE;
		var scanner = new Scanner(System.in);

		String line;
		do {
			line = scanner.nextLine();
			if(line.equals("exit")) break;
			var output = console.run(line);
			if(output.isPresent()) {
				System.out.println(output.get());
			} else {
				System.err.println("Could not run command: \"" + line + "\"");
			}
		} while (true);
	}
}
