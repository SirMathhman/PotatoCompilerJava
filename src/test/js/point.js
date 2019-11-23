function Point_construct(x, y){
    return [x, y];
}

function Point_getX(instance){
    return instance[0];
}

function Point_getY(instance) {
    return instance[1];
}

/**
 * @return {number}
 */
function Point_distance(instance, other) {
    var deltaX = Point_getX(instance) - Point_getX(other);
    var deltaY = Point_getY(instance) - Point_getY(other);
    var xSquared = Math.pow(deltaX, 2);
    var ySquared = Math.pow(deltaY, 2);
    var distSquared = xSquared + ySquared;
    return Math.pow(distSquared, 0.5);
}

var a = Point_construct(3, 4);
var b = Point_construct(0, 0);
var distance = Point_distance(a, b);
console.log(distance.toString(10));