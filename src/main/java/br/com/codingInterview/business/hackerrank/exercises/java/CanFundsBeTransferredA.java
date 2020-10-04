package br.com.codingInterview.business.hackerrank.exercises.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
//Any global declataions can be done here
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CanFundsBeTransferredA {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(6666);
		Socket socket = serverSocket.accept();
		ClientProcessor c = new ClientProcessor(socket);
		c.init_server();
		c.start();
		// c.close_socket()
	}
}

class Node {
	List<Node> adjacents = new ArrayList<>();
	Integer value;
	boolean visited;

	public Node(Integer value) {
		this.value = value;
	}
}

class Graph {
	Map<Integer, Node> map = new HashMap<>();
	List<Node> root = new ArrayList<>();

	public void addEdge(Node nodeA, Node nodeB) {
		nodeA.adjacents.add(nodeB);
		map.get(nodeA.value).adjacents.add(nodeB);
		nodeB.adjacents.add(nodeA);
		map.get(nodeB.value).adjacents.add(nodeA);
	}

	public Node createNode(Integer value) {
		if (map.containsKey(value)) {
			return map.get(value);
		} else {
			Node newNode = new Node(value);
			map.put(value, newNode);
			root.add(newNode);
			return newNode;
		}
	}

	public Node getNode(Integer value) {
		return this.map.get(value);
	}

	public int path(Node nodeA, Node target) {
		return pathSum(nodeA, target, 0);
	}

	private int pathSum(Node nodeA, Node target, Integer sum) {
		Queue<Node> queue = new LinkedList<>();
		int path = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			path++;
			while (size-- > 0) {
				Node current = queue.poll();
				if (current.value == target.value) {
					return path;
				}
				for (Node child : current.adjacents) {
					if (!child.visited) {
						child.visited = true;
						queue.add(child);
					}
				}
			}
		}
		return 0;
	}
}

class ClientProcessor extends Thread {

	Socket clientSocket;
	InputStream clientInputStream;
	OutputStream clientOutputStream;
	Graph graph;

	ClientProcessor(Socket socket) throws IOException {
		clientSocket = socket;
		clientInputStream = clientSocket.getInputStream();
		clientOutputStream = clientSocket.getOutputStream();
		createGraph();
	}

	private void createGraph() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("training.txt"));
		graph = new Graph();
		int size = Integer.parseInt(reader.readLine());
		String line = null;
		while ((line = reader.readLine()) != null && size-- > 0) {

			String[] items = line.split(",");
			int valueA = Integer.parseInt(items[0]);
			int valueB = Integer.parseInt(items[1]);

			Node nodeA = graph.createNode(valueA);
			Node nodeB = graph.createNode(valueB);

			graph.addEdge(nodeA, nodeB);
		}
		reader.close();

	}

	/*
	 * This function is called only once before any client connection is accepted by
	 * the server. Read any global datasets or configurations here
	 */
	public static void init_server() {
		System.out.println("Initializing server");
	}

	/*
	 * Write your code here This function is called everytime a new connection is
	 * accepted by the server
	 */
	public void run() {
		do {
			String message = null;

			/* read message */
			try {
				message = read_string_from_socket();
			} catch (IOException ex) {
				System.out.println("Exception: " + ex);
			}

			/* End of operation on this client */
			if (message.equals("END"))
				break;

			System.out.println("Received = " + message);

			String[] items = message.split(",");

			int valueA = Integer.parseInt(items[0]);
			int valueB = Integer.parseInt(items[1]);
			int lmt = Integer.parseInt(items[2]);

			int path = graph.path(graph.getNode(valueA), graph.getNode(valueB));

			if (path > 0 && path <= lmt) {
				message = "YES";
			} else {
				message = "NO";
			}

			/* write message */
			try {
				write_string_to_socket(message);
			} catch (IOException ex) {
				System.out.println("Exception: " + ex);
			}
		} while (true);

		// Send end of communication. Very important!
		try {
			write_string_to_socket("END");
		} catch (IOException ex) {
			System.out.println("Exception: " + ex);
		}

		try {
			close_socket();
		} catch (IOException ex) {
			System.out.println("Exception: " + ex);
		}

		return;
	}

	/*
	 * This function encapsulates the communication protocol. Do not edit this
	 * function
	 */
	public String read_string_from_socket() throws IOException {
		// Read payload
		byte[] len_network_order = new byte[4];
		clientInputStream.read(len_network_order);

		// Get message length from payload
		ByteBuffer bb = ByteBuffer.wrap(len_network_order);
		int message_length = bb.getInt();

		// Read message length bytes
		byte[] message_bytes = new byte[message_length];
		clientInputStream.read(message_bytes);

		// Convert bytes to string and return
		String message = new String(message_bytes, "UTF-8");
		return message;
	}

	/*
	 * This function encapsulates the communication protocol. Do not edit this
	 * function
	 */
	public void write_string_to_socket(String message) throws IOException {
		// Read length of message and write message header
		int messageLength = message.length();
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.order(ByteOrder.BIG_ENDIAN);
		bb.putInt(messageLength);
		bb.flip();
		clientOutputStream.write(bb.array());

		// Now write the message itself
		byte[] message_bytes = message.getBytes();
		bb = ByteBuffer.allocate(messageLength);
		bb.order(ByteOrder.BIG_ENDIAN);
		bb.put(message_bytes);
		bb.flip();
		clientOutputStream.write(bb.array());
	}

	/*
	 * This function encapsulates the communication protocol. Do not edit this
	 * function
	 */
	public void close_socket() throws IOException {
		clientInputStream.close();
		clientOutputStream.close();
		clientSocket.close();
	}
}
