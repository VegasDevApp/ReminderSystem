public enum Urgency {
    Normal, Important, Critical;

    public static Urgency Rand(){
        return Urgency.values()[(int) (Math.random() * 3)];
    }
}
