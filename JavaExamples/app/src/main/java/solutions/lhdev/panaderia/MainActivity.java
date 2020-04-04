package solutions.lhdev.panaderia;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

public class MainActivity extends Activity {

    private int[] almacenPanes = {3,2,5,1,4};
    private Vector<String> tiposDePanes;
    private ArrayList<String> clientes = new ArrayList<String>();
    private Stack<String> platos;
    private HashMap clientesMap;
    private TreeMap panesTree;
    private HashSet numeros;
    private LinkedList<String> platosLinked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //supongamos que sacamos un pan de tipo mantequilla
        almacenPanes[4]--;

        recorrerAlmacenPanes();
        //Escribamos pan del 0 al 4, 5 opciones.
        hacerPan(0);
        recorrerAlmacenPanes();

        recorrerTiposDePanes();
        recorrerClientes();
        ponerLaMesa();
        recorrerClientesMap();
        recorrerPanesTree();
        jugarConNumeros();
        recorrerPlatosLinked();

    }

    public void recorrerAlmacenPanes()
    {
        System.out.printf("\n\n********** RECORRER ALMACEN DE PANES **********\n\n");

        for (int fila = 0; fila < almacenPanes.length; fila++)
        {

            //En un array donde la segunda dimension tiene más de un valor, debemos hacer un doble for como este
            /**for (int col = 0; col <= almacenPanes[fila].length; col++)
            {
                System.out.println("la fila de pan de tipo " + fila + " tiene " + almacenPanes[fila][col] + " panes.");
             }**/

            System.out.println("la fila de pan de tipo " + fila + " tiene " + almacenPanes[fila] + " panes.");
        }
    }

    //Juega aquí con el if.
    public void hacerPan(int idPan)
    {
        System.out.printf("\n\n********** HACER PAN **********\n\n");

        almacenPanes[idPan]++;
        System.out.println("Has agregado un pan en la fila" + idPan);

        /*switch (idPan)
        {
            case 0:
                almacenPanes[idpan][0]++;
                System.out.println("Has agregado un pan en la fila 0");
                break;
            case 1:
                almacenPanes[1][0]++;
                System.out.println("Has agregado un pan en la fila 1");
                break;
            case 2:
                almacenPanes[2][0]++;
                System.out.println("Has agregado un pan en la fila 2");
                break;
            case 3:
                almacenPanes[3][0]++;
                System.out.println("Has agregado un pan en la fila 3");
                break;
            case 4:
                almacenPanes[4][0]++;
                System.out.println("Has agregado un pan en la fila 4");
                break;
            default:
                System.out.println("opcion invalida");
                break;
        }*/
        /*
        if (idPan == 0)
        {
            almacenPanes[0][0]++;
            System.out.println("Has agregado un pan en la fila 0");
        }
        else if (idPan == 1)
        {
            almacenPanes[1][0]++;
            System.out.println("Has agregado un pan en la fila 1");
        }
        else
        {
            System.out.println("opcion invalida");
        }*/
        //¿Quien visualiza que esto es una tonteria?
    }

    public void recorrerTiposDePanes()
    {
        System.out.printf("\n\n********** RECORRER TIPOS DE PANES **********\n\n");

        tiposDePanes = new Vector<String>();

        tiposDePanes.add("Baguette");
        tiposDePanes.add("Pan de molde");
        tiposDePanes.add("Pan dulce");
        tiposDePanes.add("Pan integral");
        tiposDePanes.add("Pan de mantequilla");

        /*int i=0;
        //Dos formas diferentes:
        for (String tipo: tiposDePanes)
        {
            System.out.println("tipo " + i + ": " + tipo);
            i++;
        }*/
        for (int j = 0; j < tiposDePanes.size(); j++)
        {
            System.out.println("tipo " + j + ": " + tiposDePanes.get(j));
        }

        /**La gracia de utilizar vectores es que es más facil gestionarlo cuando varios hilos quieren acceder a él,
         * y ya nos abstrae la funcionalidad de un array.
         * Para iterar, podríamos uar también ListIterator, como veremos debajo.
         */

    }

    public void recorrerClientes()
    {
        System.out.printf("\n\n********** RECORRER CLIENTES **********\n\n");
        clientes = new ArrayList<String>();

        clientes.add("Juan");
        clientes.add("Andres");
        clientes.add("Christopher");
        clientes.add("Begoña");
        clientes.add("Cristian");

        //Dos formas:
        /*for (String cliente: clientes)
        {
            System.out.println(cliente);
        }*/

        ListIterator i = clientes.listIterator();
        while (i.hasNext())
        {
            System.out.println(i.next());
        }

        // Os recomiendo usar LinkedList si debéis cambiar muchas veces el orden de los elementos en listas.
        //El ArrayList es más inteligente para añadir nuevos elementos.
    }

    public void ponerLaMesa()
    {
        System.out.printf("\n\n********** PONER LA MESA **********\n\n");

        //Traemos platos del lavavajillas
        platos = new Stack<String>();
        platos.push("Plato Verde");
        platos.push("Plato Amarillo");
        platos.push("Plato Azul");
        platos.push("Plato Purpura");
        platos.push("Plato Azul");

        System.out.println("El último plato agregado es " + platos.peek());

        //Y ahora los llevamos a la mesa. A la consola.
        /*while(!platos.isEmpty())
        {
            System.out.println(platos.pop());
        }*/

        //Para verlos:

        for (String plato: platos)
        {
            System.out.println(plato);
        }

        /*
        ListIterator i = platos.listIterator();

        while (i.hasNext())
        {
            System.out.println(i.next());
        }*/

        /*
        for (int x=0; x < platos.size(); x++)
        {
            System.out.println(platos.get(x));
        }*/

        // ¿Que pasaría con este código?
        /*while(!platos.isEmpty())
        {
            System.out.println(platos.peek());
        }*/
/*
        //Para ver los platos en el orden del pop sin cargarnos los platos:
        System.out.println("Listamos sin cargarnos los platos:".toUpperCase());
        Stack<String> platosClone = (Stack<String>) platos.clone();

        while(!platosClone.isEmpty())
        {
            System.out.println(platosClone.pop());
        }*/

    }

    public void recorrerClientesMap()
    {
        System.out.printf("\n\n********** Recorrer ClientesMap **********\n\n");

        clientesMap = new HashMap();
        Random r = new Random();

        for (int x = 1; x <= 5; x++)
        {
            clientesMap.put(x, r.nextInt(1000)+1);
            System.out.println("Cliente " + x +" tiene un credito de " + clientesMap.get(x) + " Euros");
        }

        //clientesMap.put(25,500);

        //Recorremos
        //Aqui el ForEach no nos vale
/*
        Set<String> set = clientesMap.entrySet();
        Iterator is = set.iterator();

        while(is.hasNext())
        {
            System.out.println(is.next());
        }*/

        //Set ikSet = clientesMap.keySet();


        ArrayList list = new ArrayList();
        list.add(clientesMap);

        System.out.println(list);
        /*
        for (Object cliente: list)
        {
            System.out.println(cliente.toString());
        }*/


/*        ArrayList<Integer> nombres = new ArrayList<Integer>(); // Corregido!
        nombres.addAll(clientesMap.values()); //solo los valores

        for (Object cliente: nombres)
        {
            System.out.println(cliente.toString());
        }
*/
    }

    public void recorrerPanesTree()
    {
        System.out.printf("\n\n********** Recorrer PanesTree **********\n\n".toUpperCase());

        panesTree = new TreeMap();
        /*panesTree.put(1, "Baguette");
        panesTree.put(2, "Pan de molde");
        panesTree.put(3, "Pan dulce");
        panesTree.put(5, "Pan integral");
        panesTree.put(4, "Pan de mantequill");
        panesTree.put(4, "Pan de mantequilla");
        panesTree.put(4, "Pan de mantequilla");
        panesTree.put(6, "Pan de mantequilla");*/

        panesTree.put("A", "Baguette");
        panesTree.put("Bebe", "Pan de molde");
        panesTree.put("patata", "Pan dulce");
        panesTree.put("dedo", "Pan integral");
        panesTree.put("elefante", "Pan de mantequill");
        panesTree.put("elefante", "Pan de mantequilla");
        panesTree.put("elefante", "Pan de mantequi");
        panesTree.put("clase", "Pan de mantequilla");

        //Listamos:
        Set<String> set = panesTree.entrySet();
        Iterator is = set.iterator();

        while(is.hasNext())
        {
            System.out.println(is.next());
        }

/*
        ArrayList list = new ArrayList();
        list.add(panesTree);

        System.out.println(list);*/

    }

    public void jugarConNumeros()
    {
        System.out.printf("\n\n********** JUGAR CON NUMEROS **********\n\n");

        numeros = new HashSet();
        /*numeros.add("juan");
        numeros.add("Juan");
        numeros.add("Pedro");
        numeros.add("Pedro");
        numeros.add("Pablo");
        numeros.add("ramon");*/

        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(4);

        //Listamos:
        Iterator i = numeros.iterator();
        while (i.hasNext())
        {
            System.out.println(i.next());
        }

/*
        for (Object numero: numeros)
        {
            System.out.println(numero.toString());
        }*/

    }

    public void recorrerPlatosLinked()
    {
        System.out.printf("\n\n********** RECORRER PLATOS LINKED **********\n\n");

        platosLinked = new LinkedList<String>();
        platosLinked.add("Plato Verde");
        platosLinked.add("Plato Amarillo");
        platosLinked.add("Plato Azul");
        platosLinked.add("Plato Purpura");
        platosLinked.add("Plato Azul");

        platosLinked.addLast("Plato Violeta");
        platosLinked.addFirst("Otro plato violeta");
        platosLinked.push("Un primer plato agregado al final?");

        //Listamos
        for (String plato: platosLinked)
        {
            System.out.println(plato);
        }
    }
}