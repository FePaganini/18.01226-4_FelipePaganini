package enums;

public enum Raca {
    HUMANO{
        @Override
        public String toString(){
            return "Humano";
        }
    },
    ELFO{
        @Override
        public String toString(){
            return "Elfo";
        }
    },
    SLIME{
        @Override
        public String toString(){
            return "Slime";
        }
    },
    TROLL{
        @Override
        public String toString(){
            return "Troll";
        }
    },
    DEMONIO{
        @Override
        public String toString(){
            return "Demonio";
        }
    },
    FANTASMA{
        @Override
        public String toString(){
            return "Fantasma";
        }
    }
}
