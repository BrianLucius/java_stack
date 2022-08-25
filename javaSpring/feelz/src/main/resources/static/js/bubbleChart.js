// Courtesy of https://www.webtips.dev/how-to-make-interactive-bubble-charts-in-d3-js
const width = 500;
const height = 500;
const colors = {
    0: '#FF9AA2',
    1: '#FFB7B2',
    2: '#FFDAC1',
    3: '#E2F0CB',
    4: '#B5EAD7',
    5: '#C7CEEA',
    6: '#FFAC81',
    7: '#FF928B',
    8: '#FEC3A6',
    9: '#EFE9AE',
    10: '#CDEAC0'
};

const generateChart = data => {
    const bubble = data => d3.pack()
        .size([width, height])
        .padding(2)(d3.hierarchy({ children: data }).sum(d => d.count));
        
    const title = d3.select('#bubble-chart-title')
    	.text('Trending emotions from the past 24 hours:');
		
	const svg = d3.select('#bubble-chart')
        .style('width', width)
        .style('height', height);
    
    const root = bubble(data);

    const node = svg.selectAll()
        .data(root.children)
        .enter().append('g')
        .attr('transform', `translate(${width / 2}, ${height / 2})`);
        
    const circle = node.append('circle')
        .style('fill', d => colors[Math.floor(Math.random()*11)]);
        
    const label = node.append('text')
        .attr('dy', 5)
        .attr('dx', d => -d.r+((2*d.r-getTextWidth(d.data.emotion))/2) ) 
        .text(d => d.data.emotion)
        .style('font-size', d => d.r/getTextWidth(d.data.emotion)+0.15+'rem');
        
    node.transition()
        .ease(d3.easeExpInOut)
        .duration(1000)
        .attr('transform', d => `translate(${d.x}, ${d.y})`);
    
    circle.transition()
        .ease(d3.easeExpInOut)
        .duration(1000)
        .attr('r', d => d.r);
    
    label.transition()
        .delay(700)
        .ease(d3.easeExpInOut)
        .duration(1000)
        .style('opacity', 1)
};

function getTextWidth(text, font) {
  // re-use canvas object for better performance
  const canvas = getTextWidth.canvas || (getTextWidth.canvas = document.createElement("canvas"));
  const context = canvas.getContext("2d");
  context.font = font;
  const metrics = context.measureText(text);
  return metrics.width;
}

async function renderBubbleChart() {
//	fetch ('http://localhost:8080/api/trending')
	fetch ('https://feelz.cc/api/trending')
		.then(function(response) {
			return response.json();
		})
		.then(function(data) {
			generateChart(data);
		});
};

renderBubbleChart();