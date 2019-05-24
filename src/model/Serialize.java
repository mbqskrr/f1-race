package model;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Serialize {
	
	public static final String file = "persistence.txt";
	
	public void load() throws IOException, ClassNotFoundException;
	public void save() throws IOException, FileNotFoundException;

}
