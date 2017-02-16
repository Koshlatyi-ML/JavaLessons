package oop.lection8;

class EntityDTO {
    private int field1;
    private int field2;
    private int field3;

    public int getField1() {
        return field1;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }

    public int getField2() {
        return field2;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    public int getField3() {
        return field3;
    }

    public void setField3(int field3) {
        this.field3 = field3;
    }

    static class Builder {
        EntityDTO entityDTO;

        public Builder() {
            this.entityDTO = new EntityDTO();
        }

        public Builder addField1(int field1) {
            entityDTO.setField1(field1);
            return this;
        }

        public Builder addField2(int field2) {
            entityDTO.setField2(field2);
            return this;
        }

        public Builder addField3(int field3) {
            entityDTO.setField3(field3);
            return this;
        }

        public EntityDTO build() {
            return entityDTO;
        }
    }
}

class Entity {
    // Isn't must be matching
    private int field1;
    private int field2;
    private int field3;

    public int getField1() {
        return field1;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }

    public int getField2() {
        return field2;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    public int getField3() {
        return field3;
    }

    public void setField3(int field3) {
        this.field3 = field3;
    }
}

public class Transformer {
    public static void main(String[] args) {
        Entity entity = new Entity();
        entity.setField1(1);
        entity.setField2(2);
        entity.setField3(3);
        EntityDTO entityDTO = new EntityDTO.Builder()
                                        .addField1(entity.getField1())
                                        .addField2(entity.getField2())
                                        .addField3(entity.getField3())
                                        .build();
    }
}
