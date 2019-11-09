package com.meti.cmd;

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
			System.out.println(output);
		} while (true);
	}
}
