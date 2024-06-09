package Id206550493;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Files {
	
	public boolean isFileExist() throws FileNotFoundException, IOException, ClassNotFoundException {
		if (new File("allApartments.dat").exists()) {
			System.out.println("File founded");
			return true;
		}

		else {
			System.out.println("file doesn't exist");
			return false;
		}
	}

	public RealEstateAgency read() throws FileNotFoundException, IOException, ClassNotFoundException {
		isFileExist();
		FileInputStream readData = new FileInputStream("allApartments.dat");
		ObjectInputStream readStream = new ObjectInputStream(readData);

		RealEstateAgency l = (RealEstateAgency) readStream.readObject();
		if (l.getAllApartemnts().size() >= 0)
			l.getAllApartemnts().get(0).setIdGenerator(readStream.readInt());
		readStream.close();
		return l;
	}

	public void save(RealEstateAgency o) throws IOException {
		ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream("allApartments.dat"));
		outFile.writeObject(o);
		if (o.getAllApartemnts().size() >= 0)
			outFile.writeInt(o.getAllApartemnts().get(0).getCounter());
		outFile.close();
	}
}
