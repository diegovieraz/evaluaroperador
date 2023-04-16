package com.diegoviera.evaluaroperador.ui.Utils;

import com.diegoviera.evaluaroperador.domain.model.EvaluadorModel;

import java.util.ArrayList;
import java.util.List;

public class Constantes {

    //Database
    public static final String DATABASE_NAME = "assessment_db";

    public static final String EMPTY_STRING = "";
    public static final String SPACING = "\\s";
    public static final String SPACING_ = " ";
    public static final String MORE_SPACING = " +";
    public static final String SYMBOL_COMMA = ",";
    public static final String SYMBOL_DOT = ".";
    public static final String SYMBOL_HYPHEN = "-";
    public static final String SYMBOL_SLASH = "/";
    public static final String SIMBOL_USD = "$";
    public static final String SIMBOL_OBLIGATORIO = "(*)";
    public static final String REPLACE_ZERO = "{{0}}";
    public static final String REPLACE_ONE = "{{1}}";
    public static final int EMPTY_INTEGER = 0;


    //Lista Evaluadores
    public static List<EvaluadorModel> evaluadorModels = new ArrayList<>();
    public static EvaluadorModel eval01 = new EvaluadorModel(1,"udios","udios","Ulises","Dios","Asistente","CALIDAD");
    public static EvaluadorModel eval02 = new EvaluadorModel(2,"egomez","egomez","Edith","Gomez","Supervisor","CALIDAD");
    public static EvaluadorModel eval03 = new EvaluadorModel(3,"jmedina","jmedina","Jesús","Medina","Asistente","CALIDAD");
    public static EvaluadorModel eval04 = new EvaluadorModel(4,"rhoyos","rhoyos","Rosa","Hoyos","Jefe","BBVA");
    public static EvaluadorModel eval05 = new EvaluadorModel(5,"tsalazar","tsalazar","Thebaida","Salazar","Coordinador","BBVA");
    public static EvaluadorModel eval06 = new EvaluadorModel(6,"evegabazan","evegabazan","Esthefany","Vegabazan","Coordinador","BBVA");
    public static EvaluadorModel eval07 = new EvaluadorModel(7,"asandoval","asandoval","Ailyn","Sandoval","Coordinador","BBVA");
    public static EvaluadorModel eval08 = new EvaluadorModel(8,"tkusakabe","tkusakabe","Toshiro","Kusakabe","Coordinador","INTERBANK RJ");
    public static EvaluadorModel eval09 = new EvaluadorModel(9,"marevalo","marevalo","Mircia","Arévalo","Coordinador","BANBIF");
    public static EvaluadorModel eval10 = new EvaluadorModel(10,"mgamboa","mgamboa","María","Gamboa","Coordinador","EFECTIVA");
    public static EvaluadorModel eval11 = new EvaluadorModel(11,"jcastillo","jcastillo","Johana","Castillo","Coordinador","BBVA");
    public static EvaluadorModel eval12 = new EvaluadorModel(12,"lgonzales","lgonzales","Lilia","Gonzales","Coordinador","BBVA");
    public static EvaluadorModel eval13 = new EvaluadorModel(13,"sperca","sperca","Steven","Perca","Coordinador","BBVA");
    public static EvaluadorModel eval14 = new EvaluadorModel(14,"klopez","klopez","Karol","Lopez","Coordinador","BBVA");

    //USUARIO LOGEADO
    public static EvaluadorModel evaluadoLog = new EvaluadorModel();



}
