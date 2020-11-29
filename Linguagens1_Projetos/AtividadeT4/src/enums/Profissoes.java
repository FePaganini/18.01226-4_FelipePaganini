package enums;

/**
 * Enum que apresenta as Profissões existentes para os personagens
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com
 * @since 29/11/2020
 * @version 1.0
 */
public enum Profissoes {
    FERREIRO{
        /**
         * @return retorna uma String a partir do Enum
         */
        @Override
        public String toString(){
            return "Ferreiro";
        }
    },
    ELETRICISTA{
        /**
         * @return retorna uma String a partir do Enum
         */
        @Override
        public String toString(){
            return "Eletricista";
        }
    },
    ALQUIMISTA{
        /**
         * @return retorna uma String a partir do Enum
         */
        @Override
        public String toString(){
            return "Alquimista";
        }
    },
    PESCADOR{
        /**
         * @return retorna uma String a partir do Enum
         */
        @Override
        public String toString(){
            return "Pescador";
        }
    }
}
