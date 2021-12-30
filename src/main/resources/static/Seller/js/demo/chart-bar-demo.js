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
var ctx = document.getElementById("myBarChart");
var myBarChart = new Chart(ctx, {
    type: "bar",
    data: {
        labels: ["January", "February", "March", "April", "May", "June"],
        datasets: [{
            label: "Revenue",
            backgroundColor: "#4e73df",
            hoverBackgroundColor: "#2e59d9",
            borderColor: "#4e73df",
            data: [4215, 5312, 6251, 7841, 9821, 14984],
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
                    unit: "month"
                },
                gridLines: {
                    display: false,
                    drawBorder: false
                },
                ticks: {
                    maxTicksLimit: 6
                },
                maxBarThickness: 25,
            }],
            yAxes: [{
                ticks: {
                    min: 0,
                    max: 15000,
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
            titleMarginBottom: 10,
            titleFontColor: "#6e707e",
            titleFontSize: 14,
            backgroundColor: "rgb(255,255,255)",
            bodyFontColor: "#858796",
            borderColor: "#dddfeb",
            borderWidth: 1,
            xPadding: 15,
            yPadding: 15,
            displayColors: false,
            caretPadding: 10,
            callbacks: {
                label: function(c, a) {
                    var b = a.datasets[c.datasetIndex].label || "";
                    return b + ": $" + number_format(c.yLabel)
                }
            }
        },
    }
});