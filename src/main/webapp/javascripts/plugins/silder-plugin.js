function Pages(params, changeEvent) {

    params.ratio = params.ratio || 0.1;
    params.initIdx = params.initIdx || 0;
    // 分页插件实体
    var $this = {};

    var $pages = $(params.selector);

    // 避免内部元素溢出显示
    $pages.css('position', 'relative');

    var width = $(params.selector).width();

    $this.$pages = $pages;

    var $itemContainer = $pages.children('.item-container');
    $itemContainer.children('.silder-item').width(width);
    var $items = $itemContainer.children('.silder-item');

    $this.$items = $items;
    var itemCount = $items.length;
    $this.itemCount = itemCount;

    // 添加索引显示
    if (params.showIdx && params.showIdx == true) {
        addIdxContainer();
    }

    $this.onchange = changeEvent;

    $itemContainer.width(width * itemCount);

    var maxIdx = itemCount - 1;
    var curIdx = params.initIdx;
    var curLeft = 0;
    var startX;
    $items.on('touchstart', function(event) {
        startX = event.originalEvent.changedTouches[0].pageX;
        // console.log('startX' + startX);
    });

    $items.on('touchmove', function(event) {
        var movedX = event.originalEvent.targetTouches[0].pageX;
        // console.log('movedX = ' + movedX);
        var x = movedX - startX;
        // console.log('x = ' + x);
        x = curLeft + x;
        // console.log('left = ' + x);
        // 不可划出边缘百分之十五
        if (x > width * 0.15 || x < -((itemCount - 1) * width + (width * 0.15))) {
            return;
        }
        $itemContainer.css('left', x);
    });

    $items.on('touchend', function(event) {
        var moveEndX = event.originalEvent.changedTouches[0].pageX;
        var x = moveEndX - startX;
        // console.log('moveEndX = ' + moveEndX);
        // console.log('x = ' + x);
        var ratio = (Math.abs(x) / width);
        // console.log('百分比：' + ratio);
        var nextIdx = 0;
        if (ratio > params.ratio) {
            if (x < 0) {
                // 下一个
                nextIdx = curIdx + 1;
            } else {
                // 上一个
                nextIdx = curIdx - 1;
            }
        } else {
            nextIdx = curIdx;
        }
        moveTo(nextIdx);
    });

    // 构造成功即触发一次变更事件
    try {
        $this.onchange.call($this, curIdx, curIdx, $items[curIdx]);
        // moveTo(curIdx);
    } catch (e) {
        console.error(e);
    }

    changeIdxItem(curIdx);

    function moveTo(idx) {
        if (idx > maxIdx) {
            idx = maxIdx;
        }
        if (idx < 0) {
            idx = 0;
        }
        curLeft = -(idx * width);
        // setDisplay(idx);
        $itemContainer.animate({
            left: curLeft
        }, 200, function() {
            if (idx != curIdx) {
                // 改变索引图标
                changeIdxItem(idx);
                // 页面发生变化，触发变化事件
                try {
                    $this.onchange.call($this, idx, curIdx, $items[idx]);
                } catch (e) {
                    console.error(e);
                }
            }
            curIdx = idx;
        });
    }

    /**
    <div class="item-idx-container">
                <span></span>
                <span></span>
                <span></span>
            </div>
    */

    var $itemIdxs;

    function addIdxContainer() {
        $itemIdxs = new Array();
        var $idxContainer = $(document.createElement('div'));
        $idxContainer.addClass('item-idx-container');
        for (var i = 0; i < itemCount; i++) {
            var $itemIdx = $(document.createElement('span'));
            $itemIdxs[i] = $itemIdx;
            $idxContainer.append($itemIdx);
        }
        $pages.append($idxContainer)
    }

    function changeIdxItem(idx) {
        for (var i = 0; i < $itemIdxs.length; i++) {
            if (idx == i) {
                $itemIdxs[i].addClass('active');
            } else {
                $itemIdxs[i].removeClass('active');
            }
        }
    }

    $this.select = function(idx) {
        moveTo(idx);
    };

    return $this;
}