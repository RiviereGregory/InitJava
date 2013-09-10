package fr.treeptik.initjava.watchservice;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class RunWatchService {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		WatchService watchService = FileSystems.getDefault().newWatchService();

		final Path dir = Paths.get("Rep1");

		// Crée un watchKey sur le dossier ou le fichier que l'on veut surveiller avec les evenement
		// que l'on veut surveiller créer , supprimer ou modifier le rep ou fichier surveiller 
		WatchKey key = dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

		boolean running = true;

		while (running) {
			System.out.println("Boucle ....");
			try {
				// take permet d'attendre que l'on ai un evénement
				key = watchService.take();
				if (key != null) {
					for (final WatchEvent<?> event : key.pollEvents()) {
						final Path name = (Path) event.context();
						// Affiche l'evenement qui a déclenché le watchService.take()
						System.out.format(event.kind() + " " + "%s\n", name);
					} 
					// Permet de remettre le WatchKey en mode ready
					key.reset();
				}
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}

	}

}
