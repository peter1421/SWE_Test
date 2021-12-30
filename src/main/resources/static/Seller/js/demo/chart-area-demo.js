Chart.defaults.global.defaultFontFamily = "Nunito",
'-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = "#858796";
function number_format(e, c, b, i) {
    e = (e + "").replace(",", "").replace(" ", "");
    var d = !isFinite( + e) ? 0 : +e,
    f = !isFinite( + c) ? 0 : Math.abs(c),
    h = (typeof i === "undefined") ? ",": i,
    a = (typeof b === "undefined") ? ".": b,
    g = "",
    j = function(m, o) {
        var l = Math.pow(10, o);
        return "" + Math.round(m * l) / l
    };
    g = (f ? j(d, f) : "" + Math.round(d)).split(".");
    if (g[0].length > 3) {
        g[0] = g[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, h)
    }
    if ((g[1] || "").length < f) {
        g[1] = g[1] || "";
        g[1] += new Array(f - g[1].length + 1).join("0")
    }
    return g.join(a)
}
var ctx = document.getElementById("myAreaChart");
var myLineChart = new Chart(ctx, {
    type: "line",
    data: {
        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        datasets: [{
            label: "Earnings",
            lineTension: 0.3,
            backgroundColor: "rgba(78, 115, 223, 0.05)",
            borderColor: "rgba(78, 115, 223, 1)",
            pointRadius: 3,
            pointBackgroundColor: "rgba(78, 115, 223, 1)",
            pointBorderColor: "rgba(78, 115, 223, 1)",
            pointHoverRadius: 3,
            pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
            pointHoverBorderColor: "rgba(78, 115, 223, 1)",
            pointHitRadius: 10,
            pointBorderWidth: 2,
            data: [0, 10000, 5000, 15000, 10000, 20000, 15000, 25000, 20000, 30000, 25000, 40000],
        }],
    },
    options: {
        maintainAspectRatio: false,
        layout: {
            padding: {
                left: 10,
                right: 25,
                top: 25,
                bottom: 0
            }
        },
        scales: {
            xAxes: [{
                time: {
                    unit: "date"
                },
                gridLines: {
                    display: false,
                    drawBorder: false
                },
                ticks: {
                    maxTicksLimit: 7
                }
            }],
            yAxes: [{
                ticks: {
                    maxTicksLimit: 5,
                    padding: 10,
                    callback: function(b, a, c) {
                        return "$" + number_format(b)
                    }
                },
                gridLines: {
                    color: "rgb(234, 236, 244)",
                    zeroLineColor: "rgb(234, 236, 244)",
                    drawBorder: false,
                    borderDash: [2],
                    zeroLineBorderDash: [2]
                }
            }],
        },
        legend: {
            display: false
        },
        tooltips: {
            backgroundColor: "rgb(255,255,255)",
            bodyFontColor: "#858796",
            titleMarginBottom: 10,
            titleFontColor: "#6e707e",
            titleFontSize: 14,
            borderColor: "#dddfeb",
            borderWidth: 1,
            xPadding: 15,
            yPadding: 15,
            displayColors: false,
            intersect: false,
            mode: "index",
            caretPadding: 10,
            callbacks: {
                label: function(c, a) {
                    var b = a.datasets[c.datasetIndex].label || "";
                    return b + ": $" + number_format(c.yLabel)
                }
            }
        }
    }
});