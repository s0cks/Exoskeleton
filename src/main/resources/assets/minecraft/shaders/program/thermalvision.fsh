#version 120

uniform sampler2D DiffuseSampler;

varying vec2 texCoord;

void main(){
 vec4 inTexel = texture2D(DiffuseSampler, texCoord);
}