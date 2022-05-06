var ctx=document.getElementById("canvas");
var content=ctx.getContext("2D");

var cWidth=document.documentElement.clientWidth;
var cHeight=document.documentElement.clientHeight;
var round=[];
ctx.width=cWidth;
ctx.height=cHeight;
var roundPopulation=300;
function Round_item(index,x,y) {
    this.index=index;
    this.x=x;
    this.y=y;
    this.r=Math.random()*2+1;
    var opa=(Math.floor(Math.random()*10)+1)/10/2;
    this.color="rgba("+Math.floor(Math.random()*360)+","+Math.floor(Math.random()*360)+","+Math.floor(Math.random()*360)+","+opa+")";
}
Round_item.prototype.draw=function () {
    content.fillStyle=this.color;
    content.shadowBlur = this.r*2;
    content.beginPath();
    content.arc(this.x,this.y,this.r,0,2*Math.PI,false);
    content.closePath();
    content.fill();
};
Round_item.prototype.move=function () {
    this.y-=1.5;
    if (this.y<=-10){
        this.y=10+cHeight;
    }
    this.draw();
};

function animate() {
    content.clearRect(0, 0, cWidth, cHeight);
    for (var i in round) {
        round[i].move();
    }
    requestAnimationFrame(animate);
}
function init() {
    for (var i=0;i<roundPopulation;i++){
        round[i]=new Round_item(i,Math.random()*cWidth,Math.random()*cHeight);
        round[i].draw();
    }
    animate();
}
init();
