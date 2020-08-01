package autowire;

public class Master {
        private String name;
        private Dog dog;

        private Master(Dog dog){
            //为了自动装配的constructor
            this.dog= dog;
        }


    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Dog getDog() {
            return dog;
        }

        public void setDog(Dog dog) {
            this.dog = dog;
        }
}
