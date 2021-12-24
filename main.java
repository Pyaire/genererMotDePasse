class main extends Program{

    void algorithm(){
        boolean estPossible = false;
        int total,chiffres,maj,spe;
        do{
        println("Combien de caractere souhaites-tu ?");
        total = readInt();
        println("Combien de chiffres veux tu ?");
        chiffres = readInt();
        println("combien de majuscule veux-tu ?");
        maj = readInt();
        println("pour finir combien de caractere speciaux veux tu ?");
        spe = readInt();
        if(total>= chiffres + maj + spe){
            estPossible = true;
        }else{
            println("Tu te fous de ma gueule ?");
            delay(1000);
            println("tu te rend bien compte que c'est pas possible j'espere ... ?");
            delay(2000);
        }
        }while(!estPossible);
        // delay(200);
        // println("laisse moi melanger tout ca");
        // print(".");
        // delay(1000);
        // print(".");
        // delay(1000);
        // println(".");
        // delay(1500);
        // println("FINI :");
        // delay(1500);
        String test = baseMDP(total,chiffres,spe,maj);
        println(test);
        println(coder(test));
        println(decoder(coder(test)));
        
    }

    String baseMDP(int total, int chiffres, int spe, int maj){
        String etape1 = "";
        String fin = "";
        String cara = "&#@-_=+$*%!"; 
        int nbMin = total - chiffres - spe - maj;
        do{
        for (int i = 0 ; i< chiffres ; i++){
            double acc = random()*10;
            int etat = (int) acc + 48;
            etape1 += (char) etat;
        }
        for (int i = 0 ; i< spe ; i++){
            double acc = random()*length(cara);
            int etat = (int) acc;
            char enCours = charAt(cara,etat);
            etape1 += enCours;
        }
        for (int i = 0 ; i< maj ; i++){
            double acc = random()*26;
            int etat = (int) acc + 65;
            etape1 += (char) etat;
        }
        for (int i = 0 ; i< nbMin ; i++){
            double acc = random()*26;
            int etat = (int) acc + 97;
            etape1 += (char) etat;
        }
        }while(length(etape1) != total);
        // generation mot de passe != random

        for (int i = 0 ; i < total ; i++){
            double acc = (random()*(length(etape1)));
            int etat = (int) acc;
            fin += charAt(etape1,etat);
            String gauche = substring(etape1,0,etat);
            String droite = substring(etape1, etat+1,length(etape1));
            etape1 = gauche + droite;
            // println(etape1);
        }
        return fin;
    }

    String coder(String mdp){
        String fin = "";
        int taille = length(mdp);
        char enCours;
        int changement = taille % 4;
        for (int i = 0 ; i < taille ; i++){
            enCours = charAt(mdp,i);
            enCours =(char) (enCours + changement);
            fin += enCours;
        }
        return fin;
    }

    String decoder (String mdp){
        String fin = "";
        int taille = length(mdp);
        char enCours;
        int changement = taille % 4;
        for (int i = 0 ; i < taille ; i++){
            enCours = charAt(mdp,i);
            enCours = (char) (enCours - changement);
            fin += enCours;
        }
        return fin;
    }
}