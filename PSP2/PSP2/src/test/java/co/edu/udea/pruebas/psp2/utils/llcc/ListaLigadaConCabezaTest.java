
package co.edu.udea.pruebas.psp2.utils.llcc;


import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;


public class ListaLigadaConCabezaTest {

    private static Integer[] datos;

    @BeforeClass
    public static void setup() {
        datos = new Integer[]{5025, 6156, 79830, 217304, 238512, 299278, 306825,
            404025, 417287, 426780, 437301, 492944, 494907, 539096, 703438,
            763531, 766915, 794809, 830949, 839207, 867076, 898004, 985415,
            1027858, 1042495, 1075248, 1091281, 1169508, 1240882, 1245033,
            1266141, 1284539, 1330730, 1364349, 1371931, 1402553, 1449907,
            1489206, 1516680, 1537985, 1548356, 1578478, 1596534, 1648801,
            1707873, 1762916, 1787682, 1833326, 1836872, 1873407, 1914632,
            2005512, 2090344, 2143484, 2171778, 2187217, 2192173, 2192540,
            2220621, 2223370, 2254366, 2331702, 2367037, 2425885, 2436276,
            2463493, 2541736, 2583801, 2648164, 2667420, 2668089, 2668614,
            2730857, 2756557, 2832945, 2851594, 2851939, 2860633, 2882588,
            2900644, 2910770, 2938802, 2967082, 3022221, 3119532, 3159132,
            3183181, 3282001, 3311030, 3322633, 3331001, 3344128, 3353757,
            3391929, 3393561, 3406924, 3416333, 3430419, 3465068, 3466859,
            3500527, 3508549, 3542569, 3587335, 3607980, 3667981, 3668908,
            3675048, 3691970, 3750602, 3760765, 3770080, 3777640, 3824153,
            3863170, 4049930, 4079376, 4100510, 4163795, 4220914, 4249947,
            4253119, 4274430, 4354100, 4451164, 4472220, 4486997, 4516206,
            4592860, 4659111, 4659842, 4728041, 4736921, 4738688, 4794980,
            4819672, 4841508, 4843235, 4852824, 4877399, 4885380, 4903823,
            4966361, 4973593, 4979798, 4996979, 5007466, 5009562, 5061955,
            5067262, 5087786, 5087921, 5113903, 5121419, 5180301, 5288524,
            5310996, 5334919, 5357135, 5363978, 5377138, 5394430, 5405805,
            5489470, 5501052, 5509338, 5600476, 5607166, 5611061, 5613329,
            5644126, 5658319, 5673376, 5798467, 5898965, 5939587, 5951812,
            6017871, 6033524, 6043441, 6071513, 6087809, 6145034, 6161019,
            6162672, 6211658, 6294229, 6296648, 6433074, 6492223, 6592262,
            6598427, 6605824, 6628606, 6726034, 6824879, 6893930, 7075007,
            7113051, 7113365, 7188288, 7235779, 7240354, 7248873, 7297089,
            7308728, 7333051, 7347658, 7418573, 7438156, 7509756, 7546228,
            7580557, 7590629, 7612753, 7658308, 7691745, 7731576, 7739581,
            7768559, 7797367, 7810751, 7824620, 7839681, 7884097, 7891263,
            7913662, 7920636, 7938667, 7957094, 7967297, 8012082, 8021082,
            8042551, 8057808, 8066797, 8073388, 8092189, 8109049, 8113283,
            8113466, 8142946, 8179170, 8194863, 8197203, 8205362, 8267991,
            8290629, 8310016, 8320191, 8339981, 8357971, 8384553, 8531732,
            8574152, 8583788, 8610488, 8644514, 8710283, 8762879, 8774701,
            8775000, 8781787, 8784333, 8828617, 8848705, 8911960, 8928714,
            9006594, 9042602, 9107324, 9137253, 9166297, 9185310, 9245340, 
            9261202, 9309586, 9325763, 9340688, 9368953, 9382100, 9413503, 
            9491901, 9495832, 9524734, 9537468, 9582881, 9616743, 9626374, 
            9638262, 9638292, 9651780, 9681028, 9720069, 9722967, 9816261, 
            9855566, 9864326, 9911527, 9933125};
    }
    
    

    @Test
    public void testEsVacia() {
        System.out.println("esVacia");
        ListaLigadaConCabeza instance = new ListaLigadaConCabeza();
        boolean expResult = true;
        boolean result = instance.esVacia();

        assertEquals(expResult, result);
    }

    @Test
    public void testNoEsVacia() {
        System.out.println("NoEsVacia");
        ListaLigadaConCabeza instance = new ListaLigadaConCabeza();
        instance.insertar(10);
        boolean expResult = false;
        boolean result = instance.esVacia();

        assertEquals(expResult, result);
    }

    @Test
    public void testGetPrimeroExiste() {
        System.out.println("getPrimeroExiste");
        ListaLigadaConCabeza<Integer> instance = new ListaLigadaConCabeza<>();
        instance.insertar(5);
        instance.insertar(10);
        Integer expResult = 5;
        Integer result = instance.getPrimero().getObjeto();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetPrimeroNoExiste() {
        System.out.println("getPrimeroNoExiste");
        ListaLigadaConCabeza<Integer> instance = new ListaLigadaConCabeza<>();
        Nodo<Integer> expResult = null;
        Nodo<Integer> result = instance.getPrimero();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetUltimoExiste() {
        System.out.println("getUltimoExiste");
        ListaLigadaConCabeza<Integer> instance = new ListaLigadaConCabeza<>();
        instance.insertar(5);
        instance.insertar(10);
        Integer expResult = 10;
        Integer result = instance.getUltimo().getObjeto();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetUltimoNoExiste() {
        System.out.println("getUltimoNoExiste");
        ListaLigadaConCabeza<Integer> instance = new ListaLigadaConCabeza<>();
        Nodo<Integer> expResult = null;
        Nodo<Integer> result = instance.getUltimo();
        assertEquals(expResult, result);

    }

    @Test
    public void testInsertarVacio() {
        System.out.println("testInsertarVacio");
        Integer dato = 10;
        ListaLigadaConCabeza<Integer> instance = new ListaLigadaConCabeza<>();
        instance.insertar(dato);
        assertEquals(instance.getPrimero().getObjeto(), dato);
        assertEquals(instance.getUltimo().getObjeto(), dato);
    }

    @Test
    public void testInsertarConDatos() {
        System.out.println("testInsertarConDatos");
        Integer dato = 10;
        ListaLigadaConCabeza<Integer> instance = new ListaLigadaConCabeza<>();
        instance.insertar(5);
        instance.insertar(4);
        instance.insertar(dato);
        assertEquals(instance.getUltimo().getObjeto(), dato);
    }

    @Test
    public void testFinDeRecorrido() {
        System.out.println("finDeRecorrido");
        ListaLigadaConCabeza<Integer> instance = new ListaLigadaConCabeza<>();
        instance.insertar(5);
        boolean expResult = false;
        Nodo<Integer> n = instance.getPrimero();
        boolean result = instance.finDeRecorrido(n);
        assertEquals(expResult, result);
    }

    @Test
    public void testRecorrer(){
        int j = 0;
        System.out.println("recorrer");
        ListaLigadaConCabeza<Integer> instance = new ListaLigadaConCabeza<>();
        for(int i : datos){
            instance.insertar(i);
        }
        Nodo<Integer> n = instance.getPrimero();
        while(!instance.finDeRecorrido(n)){
            assertEquals(n.getObjeto(), datos[j++]);
            n = n.getSiguiente();
        }
        
        assertEquals(datos.length, j);
    }
}
