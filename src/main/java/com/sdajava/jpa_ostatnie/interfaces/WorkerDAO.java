package main.java.com.sdajava.jpa_ostatnie.interfaces;

import main.java.com.sdajava.jpa_ostatnie.model.Worker;

import java.util.List;

public interface WorkerDAO {
	public Worker insertWorker(Worker w);

	public List<Worker> getAllWorker();

	//public void updateWorker(int id, String name, String surname);

	//public void removeWorker(int id);

	//public Worker findWorker(int id);

}
