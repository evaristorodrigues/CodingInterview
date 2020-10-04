package br.com.codingInterview.business.leetcode.exercises.java;

import java.io.IOException;

import org.junit.Test;

import br.com.codingInterview.business.hackerrank.exercises.java.SocketClient;

public class TesteSocket {

	@Test
	public void test() throws Exception {
    	SocketClient client = new SocketClient();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("4,2,2");
        System.out.println(response);
	}

}
