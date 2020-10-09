PImage img;
int value = 0;

void setup() {
  size(1280, 605);
  img = loadImage("HKPic.jpg");
  print("Manual:  ");
  print("1, Click anywhere to decrease the transparency.  ");
  print("2, Press the space bar to increase the transparency  ");
  
}

void draw() {
  image(img, 0, 0);
  drawTransparentBlind();
}

void mouseClicked() {
  lesstransparent();
}

void keyPressed() {
  moretransparent();
}

void drawTransparentBlind() {
  fill(150, value);
  strokeWeight(0.5);
  for (int i=0; i<height; i=i+5)
    rect(0, i, width, height);
}

void lesstransparent() {
  if (value == 0) {
    value = 2;
  } else if (value == 2) {
    value = 4;
  } else if (value == 4) {
    value = 6;
  } else if (value == 6) {
    value = 8;
  } else if (value == 8) {
    value = 10;
  } else if (value == 10) {
    value = 20;
  } else if (value == 20) {
    value = 30;
  } else if (value == 30) {
    value = 40;
  } else if (value == 40) {
    value = 50;
  } else if (value == 50) {
    value = 100;
  } else if (value == 100) {
    value = 150;
  } else if (value == 150) {
    value = 200;
  } else if (value == 200) {
    value = 255;
  }
}

void moretransparent() {
  if (key == ' ') {
    if (value == 255) {
      value = 200;
    } else if (value == 200) {
      value = 150;
    } else if (value == 150) {
      value = 100;
    } else if (value == 100) {
      value = 50;
    } else if (value == 50) {
      value = 40;
    } else if (value == 40) {
      value = 30;
    } else if (value == 30) {
      value = 20;
    } else if (value == 20) {
      value = 10;
    } else if (value == 10) {
      value = 8;
    } else if (value == 8) {
      value = 6;
    } else if (value == 6) {
      value = 4;
    } else if (value == 4) {
      value = 2;
    } else if (value == 2) {
      value = 0;
    }
  }
}
