package com.example.valve.graph;
//package com.softmoore.android.graphlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.softmoore.android.graphlib.Function;
import com.softmoore.android.graphlib.Graph;
import com.softmoore.android.graphlib.GraphView;
import com.softmoore.android.graphlib.Label;
import com.softmoore.android.graphlib.Point;

import java.lang.reflect.Method;


public class grafica extends AppCompatActivity {
    Button potencia, lineal, cuadratica, click;
    EditText funcion;
    String str;
    Double val;

    // METODOS PARA PASAR LA VARIABLE DIGITADO POR EL USUARIO Y TRANSFORMALA EN DOUBLE PARA QUE LA FUNCION DE TIPO FUNCTION LA RECIBA

  /*  public String getStr() {
        str = funcion.getText().toString();
        return str;
    }

    public double getVal(String funcion) {
        val = Double.parseDouble(funcion);
        return val;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica);

        potencia = (Button) findViewById(R.id.potencia);
        lineal = (Button) findViewById(R.id.lineal);
        cuadratica = (Button) findViewById(R.id.cuadratica);
        click = (Button) findViewById(R.id.click);
        funcion = (EditText) findViewById(R.id.funcion);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                str = funcion.getText().toString();
                TextView textView = findViewById(R.id.graph_view_label);
                // Convertir el string a double
                textView.setText("Grafica de " + str);

                // Convertir el string a double

                //Funcion que recibe el string siendo un double y lo regresa al Graph.Builder()

                /*Function conversion = new Function() {
                    @Override

                    public double apply(double v) {
                        grafica GRAPH;
                        GRAPH = new grafica();
                        String user = GRAPH.getStr();
                        double x = GRAPH.getVal(user);
                        return x;
                    }
                };*/


               /* Graph graph = new Graph.Builder()
                        .addFunction(conversion)
                        .build();
                GraphView graphView = findViewById(R.id.graph_view);
                graphView.setGraph(graph);*/
                setTitle("Grafica del usuario");


            }
        });


        potencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Function Funcion_a_graficar = new Function() {
                    @Override
                    public double apply(double x)
                    {
                            return x*x;
                    }
                };

                Graph graph = new Graph.Builder()
                        .addFunction(Funcion_a_graficar)
                        .build();
                GraphView graphView = findViewById(R.id.graph_view);
                graphView.setGraph(graph);
                setTitle("Grafica potencia");
                TextView textView = findViewById(R.id.graph_view_label);
                textView.setText("Grafica de x^2");
            }
        });

        lineal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Function Funcion_a_graficar = new Function() {
                    @Override
                    public double apply(double x)
                    {
                        return (x+2);
                    }
                };

                Graph graph = new Graph.Builder()
                        .addFunction(Funcion_a_graficar)
                        .build();
                GraphView graphView = findViewById(R.id.graph_view);
                graphView.setGraph(graph);
                setTitle("Grafica lineal");
                TextView textView = findViewById(R.id.graph_view_label);
                textView.setText("Grafica de x+2");
            }
        });

        cuadratica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Function Funcion_a_graficar = new Function() {
                    @Override
                    public double apply(double x)
                    {
                        return (x*x+2*x+1);
                    }
                };

                Graph graph = new Graph.Builder()
                        .addFunction(Funcion_a_graficar)
                        .build();
                GraphView graphView = findViewById(R.id.graph_view);
                graphView.setGraph(graph);
                setTitle("Grafica cuadratica");
                TextView textView = findViewById(R.id.graph_view_label);
                textView.setText("Grafica de x^2+2x+1");
            }
        });

        Graph graph = new Graph.Builder()
                .build();
        GraphView graphView = findViewById(R.id.graph_view);
        graphView.setGraph(graph);
        setTitle("Grafica prueba");
        TextView textView = findViewById(R.id.graph_view_label);
        textView.setText("Grafica de ejes X y Y");


    }
}
