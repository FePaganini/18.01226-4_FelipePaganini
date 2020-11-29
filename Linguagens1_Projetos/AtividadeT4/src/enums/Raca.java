package enums;

/**
 * Enum que apresenta as Raças existentes para os personagens
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com
 * @since 29/11/2020
 * @version 1.0
 */
public enum Raca {
    HUMANO{
        /**
         * @return retorna uma String a partir do Enum
         */
        @Override
        public String toString(){
            return "Humano";
        }
    },
    ELFO{
        /**
         * @return retorna uma String a partir do Enum
         */
        @Override
        public String toString(){
            return "Elfo";
        }
    },
    SLIME{
        /**
         * @return retorna uma String a partir do Enum
         */
        @Override
        public String toString(){
            return "Slime";
        }
    },
    TROLL{
        /**
         * @return retorna uma String a partir do Enum
         */
        @Override
        public String toString(){
            return "Troll";
        }
    },
    DEMONIO{
        /**
         * @return retorna uma String a partir do Enum
         */
        @Override
        public String toString(){
            return "Demonio";
        }
    },
    FANTASMA{
        /**
         * @return retorna uma String a partir do Enum
         */
        @Override
        public String toString(){
            return "Fantasma";
        }
    }
}
