package enums;

public enum Profissoes {
    FERREIRO{
        @Override
        public String toString(){
            return "Ferreiro";
        }
    },
    ELETRICISTA{
        @Override
        public String toString(){
            return "Eletricista";
        }
    },
    ALQUIMISTA{
        @Override
        public String toString(){
            return "Alquimista";
        }
    },
    PESCADOR{
        @Override
        public String toString(){
            return "Pescador";
        }
    }
}
