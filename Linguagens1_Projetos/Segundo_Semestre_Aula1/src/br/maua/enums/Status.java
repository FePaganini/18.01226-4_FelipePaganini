package br.maua.enums;

public enum Status {
    NAO_INICIADO{
        @Override
        public String toString() {
            return "Não Iniciado";
        }
    }
    , JOGANDO {
        @Override
        public String toString() {
            return "Jogando";
        }
            }
    , NAO_ACABADO
            {
                @Override
                public String toString() {
                    return "Não Acabado";
                }
            }
    , FINALIZADO
            {
                @Override
                public String toString() {
                    return "Finalizado";
                }
            }
    , PLATINADO
            {
                @Override
                public String toString() {
                    return "Platinado";
                }
            }
}
