/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import br.com.crackingcodinginterview.business.Project.Status;

/**
 * @author evaristosrodrigues
 *
 */

class Project {

	private ArrayList<Project> children = new ArrayList<>();
	public enum Status{COMPLETE,PARTIAL,BLANK};
	private Status status;
	private Map<String, Project> map = new HashMap<>();
	private String name;
	private int dependencies;

	public Project(String name) {
		this.name = name;
		this.status = Status.BLANK;
	}

	public void addEdge(Project project) {
		children.add(project);
		map.put(project.getName(), project);
	}

	public void incrementDependencies() {
		dependencies++;
	}

	public void derementDependencies() {
		dependencies--;
	}

	public ArrayList<Project> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Project> children) {
		this.children = children;
	}

	public Map<String, Project> getMap() {
		return map;
	}

	public void setMap(Map<String, Project> map) {
		this.map = map;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDependencies() {
		return dependencies;
	}

	public void setDependencies(int dependencies) {
		this.dependencies = dependencies;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}	
}

class BuildOrderGraph {

	private ArrayList<Project> children = new ArrayList<>();
	private Map<String, Project> map = new HashMap<>();

	public void addEdge(String a, String b) {

		Project start = createOrGet(a);
		Project end = createOrGet(b);

		start.addEdge(end);
		end.incrementDependencies();

	}

	private Project createOrGet(String key) {
		Project project;
		if (!map.containsKey(key)) {
			project = new Project(key);
			children.add(project);
			map.put(key, project);
		} else {
			project = map.get(key);
		}
		return project;
	}

	public ArrayList<Project> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Project> children) {
		this.children = children;
	}

	public Map<String, Project> getMap() {
		return map;
	}

	public void setMap(Map<String, Project> map) {
		this.map = map;
	}

	public void create(String name) {
		if (!map.containsKey(name)) {
			Project project = new Project(name);
			this.children.add(project);
			map.put(name, project);
		}
	}
}

public class BuildOrder {
	public Project[] buildOrder(String[] projects, String[][] dependencies) {
		BuildOrderGraph graph = createBuildOrderGraph(projects, dependencies);
		return projectsOrder(graph);
	}

	private Project[] projectsOrder(BuildOrderGraph graph) {

		Project[] order = new Project[graph.getChildren().size()];
		int endOfList = addProjectWithoutDependent(order, graph.getChildren(), 0);
		int toBeProcessed = 0;

		while (toBeProcessed < order.length) {
			Project project = order[toBeProcessed];
			if (project == null) {
				return null;
			}
			removeDependencies(project);
			endOfList = addProjectWithoutDependent(order, project.getChildren(), endOfList);
			toBeProcessed++;
		}

		return order;
	}

	private int addProjectWithoutDependent(Project[] order, ArrayList<Project> projects, int offset) {
		for (Project project : projects) {
			if (project.getDependencies() == 0) {
				order[offset++] = project;
			}
		}
		return offset;
	}

	public void removeDependencies(Project project) {
		for (Project child : project.getChildren()) {
			child.derementDependencies();
		}
	}

	private BuildOrderGraph createBuildOrderGraph(String[] projects, String[][] dependencies) {
		BuildOrderGraph graph = new BuildOrderGraph();
		for (String name : projects) {
			graph.create(name);
		}
		for (String[] dependency : dependencies) {
			graph.addEdge(dependency[0], dependency[1]);
		}

		return graph;
	}
	
	public Stack<Project> buildOrderDFS(String[] projects, String[][] dependencies) {
		BuildOrderGraph graph = createBuildOrderGraph(projects, dependencies);
		return projectsOrderDFS(graph);
	}

	private Stack<Project> projectsOrderDFS(BuildOrderGraph graph) {
		Stack<Project> stack = new Stack<Project>();		
		for( Project project: graph.getChildren()) {
			if(project.getStatus() == Project.Status.BLANK) {
				if(!orderDFS(project, stack)) {
					return null;
				}			
			}
		}		
		return stack ;
	}

	private boolean orderDFS(Project project, Stack<Project> stack) {
		if(project.getStatus() == Project.Status.PARTIAL) {
			return false;
		}
		if(project.getStatus() == Project.Status.BLANK) {
			project.setStatus(Project.Status.PARTIAL);
			for(Project child: project.getChildren()) {
				if(child.getStatus() != Status.COMPLETE) {
					if(!orderDFS(child, stack)){
						return false;
					}
				}
			}
		}
		project.setStatus(Project.Status.COMPLETE);
		stack.push(project);
		return true;
	}

	public static void main(String[] args) {
		String[] projects = new String[] { "a", "b", "c", "d", "e", "f" };
		String[][] dependencies = new String[][] { { "f", "a" }, { "f", "b" }, { "b", "d" }, { "a", "d" },
				{ "d", "c" } };

		// Project[] result = new BuildOrder().buildOrder(projects, dependencies);
		Project[] result = new BuildOrder().buildOrder(projects, dependencies);
		for (Project project : result) {
			System.out.println(project.getName());
		}
		System.out.println();

		Stack<Project> result2 = new BuildOrder().buildOrderDFS(projects, dependencies);
        while(!result2.isEmpty()) {
        	System.out.println(result2.pop().getName());
        }
		
		
	}

	// ############### Resposta do Livro #############################

	/* Find a cor rect build order . */
//	Project[] findBuildOrder(String[] projects, String[][] dependencies) {
//		Graph graph = buildGraph(projects, dependencies);
//		return orderProjects(graph.getNodes());
//	}
//
//	/*
//	 * Build the graph, adding the edge (a, b) if b is dependent on a. Assumes a
//	 * pair is listed in "build order». The pair (a , b) i n dependencies indicates
//	 * that b depends on a and a must be built before b.
//	 */
//	Graph buildGraph(String[] projects, String[][] dependencies) {
//		Graph graph = new Graph();
//		for (String project : projects) {
//			graph.getOrCreateNode(project);
//		}
//		for (String[] dependency : dependencies) {
//			String first = dependency[0];
//			String second = dependency[1];
//			graph.addEdge(first, second);
//		}
//		return graph;
//	}
//
//	/* Return a list of the projects a correct build order. */
//	Project[] orderProjects(ArrayList<Project> projects) {
//
//		Project[] order = new Project[projects.size()];
//		/* Add "roots» to the build order first. */
//		int endOfList = addNonDependent(order, projects, 0);
//		int toBeProcessed = 0;
//
//		while (toBeProcessed < order.length) {
//			Project current = order[toBeProcessed];
//			/*
//			 * We have a circular dependency since there are no remaining projects with zero
//			 * dependencies .
//			 */
//			if (current == null) {
//				return null;
//			}
//			/* Remove myself as a dependency. */
//			ArrayList<Project> children = current.getChildren();
//			for (Project child : children) {
//				child.decrementDependencies();
//			}
//			/* Add children that have no one depending on them. */
//			endOfList = addNonDependent(order, children, endOfList);
//			toBeProcessed++;
//
//		}
//		return order;
//	}
//
//	/*
//	 * A helper function to insert projects with zero dependencies into the order 57
//	 * * array, starting at index offset.
//	 */
//	int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
//		for (Project project : projects) {
//			if (project.getNumberDependencies() == 0) {
//				order[offset] = project;
//				offset++;
//
//			}
//		}
//		return offset;
//	}
//
//	class Graph {
//		private ArrayList<Project> nodes = new ArrayList<Project>();
//		private HashMap<String, Project> map = new HashMap<String, Project>();
//
//		public Project getOrCreateNode(String name) {
//			if (!map.containsKey(name)) {
//				Project node = new Project(name);
//				nodes.add(node);
//				map.put(name, node);
//			}
//			return map.get(name);
//		}
//
//		public void addEdge(String startName, String endName) {
//			Project start = getOrCreateNode(startName);
//			Project end = getOrCreateNode(endName);
//			start.addNeighbor(end);
//		}
//
//		public ArrayList<Project> getNodes() {
//			return nodes;
//		}
//	}
//
//	public class Project {
//		private ArrayList<Project> children = new ArrayList<Project>();
//		private HashMap<String, Project> map = new HashMap<String, Project>();
//		private String name;
//		private int dependencies = 0;
//
//		public Project(String n) {
//			name = n;
//		}
//
//		public void addNeighbor(Project node) {
//			if (!map.containsKey(node.getName())) {
//				children.add(node);
//				map.put(node.getName(), node);
//				node.incrementDependencies();
//			}
//		}
//
//		public void incrementDependencies() {
//			dependencies++;
//		}
//
//		public void decrementDependencies() {
//			dependencies--;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public ArrayList<Project> getChildren() {
//			return children;
//		}
//
//		public int getNumberDependencies() {
//			return dependencies;
//		}
//	}
}
