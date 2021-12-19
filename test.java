class test extends Program{
    void testConcat(){
        assertEquals("oui",concat());
    } 

    String concat(){
        String oui = "ou";
        char non = 'i';
        oui += non;
        return oui;
    }

    void algorithm(){
            String test = "0123456789";
        do{
        String gauche = substring(test,0,4);
        String droite = substring(test,5,length(test));
         test = gauche + droite;
        println(test);
        }while(length(test) != 0);
        
    }
}