import java.util.Scanner;
/**
 * Cette class Main contient la methode "main", qui elle contient le menu qui gère les adeherents, les cassettes et les emprunts. En plus cette class contient les 
 *2 tableaux adeherent et cassette1.
 * @author Ahmad El-Ariss 1008651
 * @author Jean Emmanuel Charles 1065027
 * @author Wissam Akchich 0870592
 * @since 12 Fevrier 2014
 * @version 1.0
 * 
 */


public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Adeherent[] adeherent = new Adeherent[100];
		Cassette[] cassette1 = new Cassette[100];
		boolean reponse = true;
		System.out
				.println("\n Bienvenue dans le club. Choisissez parmis les options suivantes:"
						+ "\n "
						+ "\n GESTION DES ADEHERENTS "
						+ "\n ---------------------------- "
						+ "\n 1) Pour ajouter un Adeherent. "
						+ "\n 2) Pour supprimer un Adeherent. "
						+ "\n 3) Pour modifier un Adeherent. "
						+ "\n 4) Pour afficher la liste des Adeherents. "
						+ "\n\n GESTION DES CASETTES "
						+ "\n ---------------------------- "
						+ "\n 5) Pour ajouter une Cassette. "
						+ "\n 6) Pour supprimer une Cassette."
						+ "\n 7) Pour modifier une Cassette."
						+ "\n 8) Pour afficher la liste des Cassettes."
						+ "\n\n GESTION DES EMPRUNTS"
						+ "\n ---------------------------- "
						+ "\n 9) Pour emprunter une Cassette."
						+ "\n 10) Pour rendre une Cassette. "
						+ "\n 11) Pour retourner la liste des personnes qui ont emprunté des Cassettes."
						+ "\n 12) Pour afficher la liste des Cassettes empruntées plusieurs personnes."
						+ "\n 13) Pour quitter.");
		
		while (reponse) {

			Scanner in = new Scanner(System.in);
			int choix = in.nextInt();
			in.nextLine();
			switch (choix) {
			
			case 1:

				System.out.print("Entrer le nom de l'Adeherent: ");
				String Nom = in.nextLine();
				Adeherent.AjouterAdeherent(Nom, adeherent);
				break;

			case 2:

				Adeherent.AfficherListe1(adeherent);
				System.out.print("Entrer l'id de l'Adeherent à supprimer: ");
				int adh_Num = in.nextInt();
				in.nextLine();
				Adeherent.supprimerAdeherent(adh_Num, adeherent);
				break;

			case 3:

				Adeherent.AfficherListe1(adeherent);
				System.out.print("Entrer l'id de l'Adeherent à modifier: ");
				int Num = in.nextInt();
				in.nextLine();
				System.out.print("Entrer le nouveau nom: ");
				String Name = in.nextLine();
				Adeherent.modifierAdeherent(Name, Num, adeherent);
				break;

			case 4:

				Adeherent.AfficherListe(adeherent);
				break;

			case 5:

				System.out.print("Entre le nom de la Cassette: ");
				String Nom1 = in.nextLine();
				System.out.print("Entre le nom du realisateur: ");
				String Realisateur = in.nextLine();
				Cassette.AjouterCassette(Nom1, cassette1, Realisateur);
				break;

			case 6:

				Cassette.AfficherListe1(cassette1);
				System.out.print("Entrer le numero de la Cassette à supprimer  ");
				int cass_Num = in.nextInt();
				in.nextLine();
				if (cassette1[cass_Num - 1] != null)
					Cassette.supprimerCassette(cass_Num, cassette1);
				else
					System.out.println("Cette Cassette n'existe pas, regardez la liste disponible et recommencez.");
				break;

			case 7:

				Cassette.AfficherListe1(cassette1);
				System.out.print("Entrer l'id de la Cassette à modifier: ");
				int Num1 = in.nextInt();
				in.nextLine();
				System.out.print("Entrer le nouveau titre: ");
				String Titre = in.nextLine();
				Cassette.modifierCassette(Titre, Num1, cassette1);
				break;

			case 8:

				Cassette.AfficherListe(cassette1);
				break;

			case 9:

				Adeherent.AfficherListe1(adeherent);
				Cassette.AfficherListe1(cassette1);
				System.out.println("Indiquer le numero de la Cassette à emprunter: ");
				int cassNum = in.nextInt();
				in.nextLine();
				if (cassette1[cassNum - 1] != null) {
					System.out.println("Indiquer le numero de l'emprunteur: ");
					int adhNum = in.nextInt();
					in.nextLine();
					Cassette.emprunter(adhNum, cassNum, adeherent, cassette1);
					if (cassette1[cassNum - 1].getNBcopies(cassette1) != -1)
						System.out
								.println("Nombre de copies de "	+ cassette1[cassNum - 1].getTitre()	+ " disponibles est: " + cassette1[cassNum - 1]	.getNBcopies(cassette1));
				} else
					System.out
							.println("Cette Cassette n'existe pas, regardez la liste disponible et recommencez.");
				break;

			case 10:

				System.out
						.println("Indiquer le numero de la Cassette à rendre: ");
				int casNum = in.nextInt();
				in.nextLine();
				System.out.println("Indiquer le numero de l'emprunteur: ");
				int ADHNum = in.nextInt();
				in.nextLine();
				Cassette.RendreCassette(ADHNum, casNum, adeherent, cassette1);
				if (cassette1[casNum - 1].getNBcopies(cassette1) <= 10) {

					System.out.println("Nombre de copies de " + cassette1[casNum - 1].getTitre() + " disponibles est: "	+ cassette1[casNum - 1].getNBcopies(cassette1));

				} else
					System.out
							.println("La Cassette n'a pas encore été encore empruntée par l'Adeherent pour que vous la rendiez.");
				break;
				
			case 11:
				
				Cassette.plusieurspersonnes(cassette1,	adeherent);
				break;
				
			case 12:
				
				Cassette.CassetteEmprunterparPlusieursAdeherents(adeherent, cassette1);
				break;
				
			case 13:
				
				reponse = false;
				System.out.print("Au revoir1.");
				break;

			}

		}
	}
}